package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.models.CreateRoomRequest;
import com.fortech.academy.library.models.ReadAllRoomsResponse;
import com.fortech.academy.library.models.UpdateRoomRequest;
import com.fortech.academy.library.services.RoomsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class RoomsController {

    private final RoomsService roomsService;

    @PostMapping
    public void createRoom(@RequestBody CreateRoomRequest requestBody, Authentication authentication) {
        log.info("createRoom");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        Room newRoom = new Room();
        newRoom.setHotelId(requestBody.getHotelId());
        newRoom.setRoomNumber(requestBody.getRoomNumber());
        newRoom.setRoomType(requestBody.getRoomType());
        newRoom.setRoomFloor(requestBody.getRoomFloor());
        newRoom.setRoomPrice(requestBody.getRoomPrice());
        roomsService.addRoom(newRoom);
    }

    @GetMapping("{id}")
    public ResponseEntity<Room> readRoomById (@PathVariable Long id) {
        try { Room responseBody = roomsService.getRoomById(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity<ReadAllRoomsResponse> readAllRooms(Authentication authentication) {
        log.info("readAllRooms");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        List<Room> rooms = roomsService.getAllRooms();
        ReadAllRoomsResponse responseBody = new ReadAllRoomsResponse(rooms);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable Long id, Authentication authentication) {
        try {
            log.info("deleteRoom");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            roomsService.deleteRoomById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}





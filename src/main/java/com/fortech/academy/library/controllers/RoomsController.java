package com.fortech.academy.library.controllers;


import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.services.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("rooms")
public class RoomsController {

    private final RoomsService roomsService;

    @Autowired
    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping("test")
    public String test() {
        return "It works...";
    }

    @PostMapping
    public void createRoom(@RequestBody CreateRoomRequest requestBody) {
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
    public List<Room> readAllRooms() {
        return roomsService.getAllRooms();
    }
}





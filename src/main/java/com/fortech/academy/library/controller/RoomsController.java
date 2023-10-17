package com.fortech.academy.library.controller;


import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        newRoom.setHotelId((long) requestBody.getHotelId());
        newRoom.setRoomNumber(requestBody.getRoomNumber());
        newRoom.setRoomType(requestBody.getRoomType());
        newRoom.setRoomFloor(requestBody.getRoomFloor());
        newRoom.setRoomPrice(requestBody.getRoomPrice());
        roomsService.addRoom(newRoom);
    }


    @GetMapping
    public List<Room> readAllRooms() {
        return roomsService.getAllRooms();
    }
}





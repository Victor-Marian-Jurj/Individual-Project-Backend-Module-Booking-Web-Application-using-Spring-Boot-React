package com.fortech.academy.library.controller;


import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<Room> readAllRooms() {
        return roomsService.getAllRooms();
    }
}





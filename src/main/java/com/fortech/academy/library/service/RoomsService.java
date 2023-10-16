package com.fortech.academy.library.service;


import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class RoomsService {

    private final RoomsRepository roomsRepository;


    @Autowired
    public RoomsService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomsRepository.findAll();
    }

}

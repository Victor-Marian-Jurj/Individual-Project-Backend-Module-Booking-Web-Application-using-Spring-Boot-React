package com.fortech.academy.library.services;


import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoomsService {

    private final RoomsRepository roomsRepository;


    @Autowired
    public RoomsService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public void addRoom(Room newRoom) {
        roomsRepository.save(newRoom);
    }

    public Room getRoomById(Long id) throws NoSuchElementException {
        return roomsRepository.findById(id).orElseThrow();
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomsRepository.findAll();
    }
}

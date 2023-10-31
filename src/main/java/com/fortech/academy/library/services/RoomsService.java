package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.repositories.RoomsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomsService {

    private final RoomsRepository roomsRepository;

    public void addRoom(Room newRoom) {
        roomsRepository.save(newRoom);
    }

    public Room getRoomById(Long id) throws NoSuchElementException {
        return roomsRepository.findById(id).orElseThrow();
    }

    @GetMapping
    public List<Room> getAllRooms() {
        log.info("getAllRooms");
        return roomsRepository.findAll();
    }

    public void deleteRoomById(Long id) {
        roomsRepository.deleteById(id);
    }
}

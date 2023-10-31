package com.fortech.academy.library.models;

import com.fortech.academy.library.entities.Room;

import java.util.ArrayList;
import java.util.List;

public class ReadAllRoomsResponse {

    private final List<Room> rooms = new ArrayList<>();

    public ReadAllRoomsResponse() {
    }

    public  ReadAllRoomsResponse(List<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

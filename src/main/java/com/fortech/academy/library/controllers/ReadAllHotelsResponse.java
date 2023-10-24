package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public class ReadAllHotelsResponse {

    private final List<Hotel> hotels = new ArrayList<>();

    public ReadAllHotelsResponse() {
    }

    public ReadAllHotelsResponse (List<Hotel> hotels) {
        this.hotels.addAll(hotels);
    }
    public List<Hotel> getHotel() {
        return hotels;
    }
}

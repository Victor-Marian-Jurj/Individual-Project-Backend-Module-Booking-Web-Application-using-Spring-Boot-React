package com.fortech.academy.library.models;

import java.util.ArrayList;
import java.util.List;

public class HotelResponse {

    private final List<HotelDTO> hotels = new ArrayList<>();

    public HotelResponse() {
    }

    public HotelResponse(List<HotelDTO> hotels) {
        this.hotels.addAll(hotels);
    }
    public List<HotelDTO> getHotel() {
        return hotels;
    }
}

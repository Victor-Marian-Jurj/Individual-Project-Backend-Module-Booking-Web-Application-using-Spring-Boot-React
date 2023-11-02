package com.fortech.academy.library.models;

import java.util.ArrayList;
import java.util.List;

public class HotelResponse {

    private final List<HotelDto> hotels = new ArrayList<>();

    public HotelResponse() {
    }

    public HotelResponse(List<HotelDto> hotels) {
        this.hotels.addAll(hotels);
    }
    public List<HotelDto> getHotel() {
        return hotels;
    }
}

package com.fortech.academy.library.controller.service;

import com.fortech.academy.library.entities.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelsService {

    public List<Hotel> getAllHotels() {
        List<Hotel> result = new ArrayList<>();
        result.add(new Hotel("Hotel Ramada", "Sibiu", 4, true, false, false, true));
        result.add(new Hotel("Hotel Hilton Garden Inn", "Bucharest", 5, true, true, true, true));
        result.add(new Hotel("Hotel Ramada", "Craiova", 4, true, true, false, true));
        return result;
    }
}

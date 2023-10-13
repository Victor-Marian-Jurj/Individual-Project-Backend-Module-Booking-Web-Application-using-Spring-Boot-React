package com.fortech.academy.library.controller;

import com.fortech.academy.library.entities.Hotel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelsController {

    @GetMapping("test")
        public String test(){
        return "It works...";
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        List<Hotel> responseBody = new ArrayList<>();
        responseBody.add(new Hotel("Hotel Ramada", "Sibiu", 4, true, false, false, true));
        responseBody.add(new Hotel("Hotel Hilton Garden Inn", "Bucharest", 5, true, true, true, true));
        responseBody.add(new Hotel("Hotel Ramada", "Craiova", 4, true, true, false, true));
   return responseBody;
    }
}

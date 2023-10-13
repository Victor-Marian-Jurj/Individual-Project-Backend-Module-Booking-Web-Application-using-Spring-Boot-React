package com.fortech.academy.library.controller;

import com.fortech.academy.library.service.HotelsService;
import com.fortech.academy.library.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelsController {

    private final HotelsService hotelsService;

    @Autowired
    public HotelsController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    @GetMapping("test")
    public String test(){
        return "It works...";
    }

    @PostMapping
    public void createBook(@RequestBody CreateHotelRequest requestBody) {
        Hotel newHotel = new Hotel();
        newHotel.setHotelName(requestBody.getHotelName());
        newHotel.setHotelLocation(requestBody.getHotelLocation());
        newHotel.setRating(requestBody.getRating());
        newHotel.setBreakfast(requestBody.isBreakfast());
        newHotel.setWifiConnection(true);
        newHotel.setPrivateParking(requestBody.isPrivateParking());
        newHotel.setMinibar(requestBody.isMinibar());
        hotelsService.addHotel(newHotel);
    }

    @GetMapping
    public List<Hotel> readAllHotels() {
        return hotelsService.getAllHotels();
    }

}

package com.fortech.academy.library.controllers;

import com.fortech.academy.library.services.HotelsService;
import com.fortech.academy.library.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("{id}")
    public ResponseEntity<Hotel> readHotelById(@PathVariable Long id) {
        try {
            Hotel responseBody = hotelsService.getHotelbyId(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Hotel> readAllHotels() {
        return hotelsService.getAllHotels();
    }

}

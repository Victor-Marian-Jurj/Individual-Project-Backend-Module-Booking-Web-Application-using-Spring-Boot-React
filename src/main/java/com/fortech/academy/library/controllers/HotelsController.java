package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Hotel;
import com.fortech.academy.library.services.HotelsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelsController {

    private final HotelsService hotelsService;

    @PostMapping
    public void createHotel(@RequestBody CreateHotelRequest requestBody) {
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
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<ReadAllHotelsResponse> readAllHotels() {
        log.info("readAllHotels");
        List<Hotel> hotels = hotelsService.getAllHotels();
        ReadAllHotelsResponse responseBody = new ReadAllHotelsResponse(hotels);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Hotel> disableHotelWifiById(@PathVariable Long id) {
        try {
            Hotel responseBody = hotelsService.disableHotelWifiById(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody UpdateHotelRequest requestBody, @PathVariable Long id) {
        try {
            Hotel responseBody = hotelsService.updateOneHotel(id);
            responseBody.setRating(requestBody.getRating());
            responseBody.setBreakfast(requestBody.isBreakfast());
            responseBody.setWifiConnection(true);
            responseBody.setPrivateParking(requestBody.isPrivateParking());
            responseBody.setMinibar(requestBody.isMinibar());
            hotelsService.updateOneHotel(responseBody.getHotelId());
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Hotel;
import com.fortech.academy.library.models.CreateHotelRequest;
import com.fortech.academy.library.models.HotelDto;
import com.fortech.academy.library.models.HotelResponse;
import com.fortech.academy.library.models.UpdateHotelRequest;
import com.fortech.academy.library.services.HotelsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class HotelsController {

    @Autowired
    private ModelMapper modelMapper;
    private final HotelsService hotelsService;

    @PostMapping
    public void createHotel(@RequestBody CreateHotelRequest requestBody, Authentication authentication) {
        log.info("createHotel");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        Hotel newHotel = new Hotel();
        newHotel.setHotelName(requestBody.getHotelName());
        newHotel.setHotelLocation(requestBody.getHotelLocation());
        newHotel.setRating(requestBody.getRating());
        newHotel.setBreakfast(requestBody.isBreakfast());
        newHotel.setWifiConnection(true);
        newHotel.setPrivateParking(requestBody.isPrivateParking());
        newHotel.setMinibar(requestBody.isMinibar());
        newHotel.setLatitude(requestBody.getLatitude());
        newHotel.setLongitude(requestBody.getLongitude());
        newHotel.setRoom(requestBody.getRoom());
        newHotel.setPrice(requestBody.getPrice());
        newHotel.setCheckInInterval(requestBody.getCheckInInterval());
        newHotel.setCheckOutInterval(requestBody.getCheckOutInterval());
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

    private HotelDto convertToDTO(Hotel hotel) {
        return modelMapper.map(hotel, HotelDto.class);
    }

    @GetMapping
    public ResponseEntity<HotelResponse> readAllHotels(Authentication authentication) {
        log.info("readAllHotels");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        List<Hotel> hotels = hotelsService.getAllHotels();
        List<HotelDto> hotelDtoList = hotels.stream().map(this::convertToDTO).collect(Collectors.toList());
        HotelResponse responseBody = new HotelResponse(hotelDtoList);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Long id, Authentication authentication) {
        try {
            log.info("deleteHotel");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            hotelsService.deleteHotelbyId(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody UpdateHotelRequest requestBody, @PathVariable Long id, Authentication authentication) {
        try {
            log.info("updateHotel");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            Hotel responseBody = hotelsService.updateHotelById(id);
            responseBody.setRating(requestBody.getRating());
            responseBody.setBreakfast(requestBody.isBreakfast());
            responseBody.setWifiConnection(requestBody.isWifiConnection());
            responseBody.setPrivateParking(requestBody.isPrivateParking());
            responseBody.setMinibar(requestBody.isMinibar());
            responseBody.setRoom(requestBody.getRoom());
            responseBody.setPrice(requestBody.getPrice());
            responseBody.setCheckInInterval(requestBody.getCheckInInterval());
            responseBody.setCheckOutInterval(requestBody.getCheckOutInterval());
            hotelsService.updateHotelById(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}

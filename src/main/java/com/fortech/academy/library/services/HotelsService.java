package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.Hotel;
import com.fortech.academy.library.repositories.HotelsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HotelsService {

    private final HotelsRepository hotelsRepository;

    @Autowired
    public HotelsService(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    public void addHotel(Hotel newHotel) {
        hotelsRepository.save(newHotel);
    }

    public Hotel getHotelbyId(Long id) throws NoSuchElementException {
        return hotelsRepository.findById(id).orElseThrow();
    }

    public List<Hotel> getAllHotels() {
        return hotelsRepository.findAll();
    }

    @Transactional
    public Hotel disableHotelWifiById(Long id) {
        Hotel hotel = hotelsRepository.findById(id).orElseThrow();
        hotel.setWifiConnection(false);
        return hotel;
    }

}

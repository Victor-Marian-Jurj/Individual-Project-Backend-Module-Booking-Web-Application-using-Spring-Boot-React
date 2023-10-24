package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.Hotel;
import com.fortech.academy.library.repositories.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelsService {

    private final HotelsRepository hotelsRepository;

    @Autowired
    public HotelsService(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelsRepository.findAll();
    }

    public void addHotel(Hotel newHotel) {
        hotelsRepository.save(newHotel);
    }
}

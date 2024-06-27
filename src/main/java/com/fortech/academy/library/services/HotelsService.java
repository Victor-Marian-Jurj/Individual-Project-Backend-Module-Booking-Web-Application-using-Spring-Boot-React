package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.Hotel;
import com.fortech.academy.library.repositories.HotelsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelsService {

    private final HotelsRepository hotelsRepository;

    public void addHotel(Hotel newHotel) {
        hotelsRepository.save(newHotel);
    }

    public Hotel getHotelbyId(Long id) throws NoSuchElementException {
        return hotelsRepository.findById(id).orElseThrow();
    }

    public List<Hotel> getAllHotels() {
        log.info("getAllHotels");
        return hotelsRepository.findAll();
    }

    @Transactional
    public void deleteHotelbyId(Long id) {
         hotelsRepository.deleteById(id);
    }

    @Transactional
    public Hotel updateHotelById(Long id) {
        Hotel hotel = hotelsRepository.findById(id).orElseThrow();
        return hotelsRepository.save(hotel);
    }
}

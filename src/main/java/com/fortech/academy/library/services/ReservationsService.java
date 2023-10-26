package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.repositories.ReservationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationsService {

private final ReservationsRepository reservationsRepository;

    public void addReservation(Reservation newReservation) {
        reservationsRepository.save(newReservation);
    }

    public Reservation getReservationById(Long id) throws NoSuchElementException {
        return reservationsRepository.findById(id).orElseThrow();

    }

    public List<Reservation> getAllReservations() {
        log.info("getAllReservations");
        return reservationsRepository.findAll();
    }
}

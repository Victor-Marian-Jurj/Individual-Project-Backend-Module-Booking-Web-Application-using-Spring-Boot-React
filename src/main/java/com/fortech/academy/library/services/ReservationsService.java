package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.repositories.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationsService {

private final ReservationsRepository reservationsRepository;

    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public void addReservation(Reservation newReservation) {
        reservationsRepository.save(newReservation);
    }

    public Reservation getReservationById(Long id) throws NoSuchElementException {
        return reservationsRepository.findById(id).orElseThrow();

    }

    public List<Reservation> getAllReservations() {
        return reservationsRepository.findAll();
    }
}

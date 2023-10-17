package com.fortech.academy.library.service;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.repository.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {

private final ReservationsRepository reservationsRepository;

    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationsRepository.findAll();
    }

    public void addReservation(Reservation newReservation) {
        reservationsRepository.save(newReservation);
    }
}

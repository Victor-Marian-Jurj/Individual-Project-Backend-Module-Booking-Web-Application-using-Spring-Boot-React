package com.fortech.academy.library.models;

import com.fortech.academy.library.entities.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationsResponse {

    private final List<ReservationDto> reservations = new ArrayList<>();

    public ReservationsResponse() {
    }

    public ReservationsResponse(List<ReservationDto> reservations) {
        this.reservations.addAll(reservations);
    }

    public List<ReservationDto> getReservations() {
        return reservations;
    }
}


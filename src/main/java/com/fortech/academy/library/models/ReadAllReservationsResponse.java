package com.fortech.academy.library.models;

import com.fortech.academy.library.entities.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReadAllReservationsResponse {

    private final List<Reservation> reservations = new ArrayList<>();

    public ReadAllReservationsResponse () {
    }

    public ReadAllReservationsResponse (List<Reservation> reservations) {
        this.reservations.addAll(reservations);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}


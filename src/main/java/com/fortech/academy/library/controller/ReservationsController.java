package com.fortech.academy.library.controller;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.service.ReservationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationsController {

    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping("test")
    public String test() {
        return "It works...";
    }

    @GetMapping
    public List<Reservation> readAllReservations() {
        return reservationsService.getAllReservations();
    }

}

package com.fortech.academy.library.controller;

import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.service.ReservationsService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void createReservation (@RequestBody CreateReservationRequest requestBody) {
        Reservation newReservation = new Reservation();
        newReservation.setUserId(requestBody.getUserId());;
        newReservation.setHotelId(requestBody.getHotelId());
        newReservation.setRoomId(requestBody.getRoomId());
        newReservation.setCheckInDate(requestBody.getCheckInDate());
        newReservation.setCheckOutDate(requestBody.getCheckOutDate());
        newReservation.setPaymentMethod(requestBody.getPaymentMethod());
        newReservation.setTotalPayment(requestBody.getTotalPayment());
        reservationsService.addReservation(newReservation);
    }
}

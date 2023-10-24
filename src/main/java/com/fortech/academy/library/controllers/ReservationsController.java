package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.services.ReservationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("{id}")
    public ResponseEntity<Reservation> readReservationById (@PathVariable Long id) {
        try {
            Reservation responseBody = reservationsService.getReservationById(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Reservation> readAllReservations() {
        return reservationsService.getAllReservations();
    }
}

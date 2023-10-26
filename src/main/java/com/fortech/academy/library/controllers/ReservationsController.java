package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.services.ReservationsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("reservations")
@RequiredArgsConstructor
@Slf4j
public class ReservationsController {

    private final ReservationsService reservationsService;

    @PostMapping
    public void createReservation(@RequestBody CreateReservationRequest requestBody) {
        Reservation newReservation = new Reservation();
        newReservation.setUserId(requestBody.getUserId());
        newReservation.setHotelId(requestBody.getHotelId());
        newReservation.setRoomId(requestBody.getRoomId());
        newReservation.setCheckInDate(requestBody.getCheckInDate());
        newReservation.setCheckOutDate(requestBody.getCheckOutDate());
        newReservation.setPaymentMethod(requestBody.getPaymentMethod());
        newReservation.setTotalPayment(requestBody.getTotalPayment());
        reservationsService.addReservation(newReservation);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> readReservationById(@PathVariable Long id) {
        try {
            Reservation responseBody = reservationsService.getReservationById(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<ReadAllReservationsResponse> readAllReservations() {
        log.info("readAllReservations");
        List<Reservation> reservations = reservationsService.getAllReservations();
        ReadAllReservationsResponse responseBody = new ReadAllReservationsResponse(reservations);
        return ResponseEntity.ok(responseBody);
    }
}

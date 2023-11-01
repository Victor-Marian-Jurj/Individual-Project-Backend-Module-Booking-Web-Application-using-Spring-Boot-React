package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.models.CreateReservationRequest;
import com.fortech.academy.library.models.ReadAllReservationsResponse;
import com.fortech.academy.library.models.UpdateReservationRequest;
import com.fortech.academy.library.models.UpdateRoomRequest;
import com.fortech.academy.library.services.ReservationsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<ReadAllReservationsResponse> readAllReservations(Authentication authentication) {
        log.info("readAllReservations");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        List<Reservation> reservations = reservationsService.getAllReservations();
        ReadAllReservationsResponse responseBody = new ReadAllReservationsResponse(reservations);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteReservationById(Long id, Authentication authentication) {
        try {
            log.info("deleteReservation");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            reservationsService.deleteReservationById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Reservation> updateReservationById(@RequestBody UpdateReservationRequest requestBody, @PathVariable Long id, Authentication authentication) {
        try {
            log.info("updateReservation");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            Reservation responseBody = reservationsService.updateReservationById(id);
            responseBody.setUserId(requestBody.getUserId());
            responseBody.setHotelId(requestBody.getHotelId());
            responseBody.setRoomId(requestBody.getRoomId());
            responseBody.setCheckInDate(requestBody.getCheckInDate());
            responseBody.setCheckOutDate(requestBody.getCheckOutDate());
            responseBody.setPaymentMethod(requestBody.getPaymentMethod());
            responseBody.setTotalPayment(requestBody.getTotalPayment());
            reservationsService.updateReservationById(id);
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}

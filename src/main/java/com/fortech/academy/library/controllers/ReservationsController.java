package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.models.*;
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
@CrossOrigin(origins = "*")
public class ReservationsController {

    private final ReservationsService reservationsService;

    @PostMapping
    public void createReservation(@RequestBody CreateReservationRequest requestBody) {
        Reservation newReservation = new Reservation();
//        newReservation.setUserId(requestBody.getUserId());
//        newReservation.setRoomId(requestBody.getRoomId());
        newReservation.setHotelId(Math.toIntExact(requestBody.getHotelId()));
        newReservation.setFirstName(requestBody.getFirstName());
        newReservation.setLastName(requestBody.getLastName());
        newReservation.setPhoneNumber(requestBody.getPhoneNumber());
        newReservation.setEmailAddress(requestBody.getEmailAddress());
        newReservation.setRoomType(requestBody.getRoomType());
        newReservation.setRoomPrice(requestBody.getRoomPrice());


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
    public ResponseEntity<ReservationsResponse> readAllReservations(Authentication authentication) {
        log.info("readAllReservations");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        List<ReservationDto> reservations = reservationsService.getAllReservations();
        ReservationsResponse responseBody = new ReservationsResponse(reservations);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable Long id, Authentication authentication) {
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
            responseBody.setReservationId(responseBody.getReservationId());
//            responseBody.setUserId(requestBody.getUserId());
            responseBody.setHotelId(requestBody.getHotelId());
//            responseBody.setRoomId(requestBody.getRoomId());
            responseBody.setFirstName(requestBody.getFirstName());
            responseBody.setLastName(requestBody.getLastName());
            responseBody.setEmailAddress(requestBody.getEmailAddress());
            responseBody.setPhoneNumber(requestBody.getPhoneNumber());
            responseBody.setRoomPrice(requestBody.getRoomPrice());
            responseBody.setRoomType(requestBody.getRoomType());
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

package com.fortech.academy.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    private Long reservationId;

    private int hotelId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String paymentMethod;

    private int totalPayment;

    private String firstName;

    private String lastName;

    private String roomType;

    private int roomPrice;

    private String hotelName;

    private String hotelLocation;

    private String phoneNumber;

    private String emailAddress;
}

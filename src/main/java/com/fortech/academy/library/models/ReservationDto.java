package com.fortech.academy.library.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    private Long reservationId;

    private int userId;

    private int hotelId;

    private int roomId;

    private Date checkInDate;

    private Date checkOutDate;

    private String paymentMethod;

    private int totalPayment;

    private String username;

    private String firstName;

    private String lastName;

    private int roomNumber;

    private String roomType;

    private int roomPrice;

    private String hotelName;

    private String hotelLocation;
}

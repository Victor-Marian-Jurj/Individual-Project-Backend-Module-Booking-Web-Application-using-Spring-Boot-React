package com.fortech.academy.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
public class HotelDto {


    private Long hotelId;

    private String hotelName;

    private String hotelLocation;

    private int rating;

    private int price;

    private String room;

    private LocalDate checkInInterval;

    private LocalDate checkOutInterval;

    private boolean breakfast;

    private boolean wifiConnection;

    private boolean privateParking;

    private boolean minibar;

    private double latitude;

    private double longitude;

    public HotelDto() {
    }


}

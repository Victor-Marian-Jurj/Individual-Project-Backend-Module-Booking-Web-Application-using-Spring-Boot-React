package com.fortech.academy.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HotelDto {


    private Long hotelId;

    private String hotelName;

    private String hotelLocation;

    private int rating;

    private boolean breakfast;

    private boolean wifiConnection;

    private boolean privateParking;

    private boolean minibar;

    public HotelDto() {
    }


}

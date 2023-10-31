package com.fortech.academy.library.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HotelDTO {


    private Long hotelId;

    private String hotelName;

    private String hotelLocation;

    private int rating;

    private boolean breakfast;

    private boolean wifiConnection;

    private boolean privateParking;

    private boolean minibar;

    public HotelDTO() {
    }


}

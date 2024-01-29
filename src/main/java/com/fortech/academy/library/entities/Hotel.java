package com.fortech.academy.library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_location")
    private String hotelLocation;

    @Column(name = "rating")
    private int rating;

    @Column(name = "breakfast")
    private boolean breakfast;

    @Column(name = "wifi_connection")
    private boolean wifiConnection;

    @Column(name = "private_parking")
    private boolean privateParking;

    @Column(name = "minibar")
    private boolean minibar;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    public Hotel() {
    }

    public Hotel(String hotelName, String hotelLocation, int rating, boolean breakfast, boolean wifiConnection, boolean privateParking, boolean minibar, double latitude, double longitude) {
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.rating = rating;
        this.breakfast = breakfast;
        this.wifiConnection = wifiConnection;
        this.privateParking = privateParking;
        this.minibar = minibar;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isWifiConnection() {
        return wifiConnection;
    }

    public void setWifiConnection(boolean wifiConnection) {
        this.wifiConnection = wifiConnection;
    }

    public boolean isPrivateParking() {
        return privateParking;
    }

    public void setPrivateParking(boolean privateParking) {
        this.privateParking = privateParking;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

package com.fortech.academy.library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "room")
    private String room;

    @Column(name = "price")
    private int price;

    @Column(name = "check_in_interval")
    private LocalDate checkInInterval;

    @Column(name = "check_out_interval")
    private LocalDate checkOutInterval;

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

    public Hotel(String hotelName, String hotelLocation, String room, int price, LocalDate checkInInterval, LocalDate checkOutInterval, int rating, boolean breakfast, boolean wifiConnection, boolean privateParking, boolean minibar, double latitude, double longitude) {
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.rating = rating;
        this.breakfast = breakfast;
        this.wifiConnection = wifiConnection;
        this.privateParking = privateParking;
        this.minibar = minibar;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.room = room;
        this.checkInInterval = checkInInterval;
        this.checkOutInterval = checkOutInterval;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getCheckInInterval() {
        return checkInInterval;
    }

    public void setCheckInInterval(LocalDate checkInInterval) {
        this.checkInInterval = checkInInterval;
    }

    public LocalDate getCheckOutInterval() {
        return checkOutInterval;
    }

    public void setCheckOutInterval(LocalDate checkOutInterval) {
        this.checkOutInterval = checkOutInterval;
    }
}

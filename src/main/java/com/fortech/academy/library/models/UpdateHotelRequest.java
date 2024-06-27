package com.fortech.academy.library.models;

import java.time.LocalDate;
import java.util.Date;

public class UpdateHotelRequest {

    private int rating;

    private int price;

    private String room;

    private LocalDate checkInInterval;

    private LocalDate checkOutInterval;

    private boolean breakfast;

    private boolean wifiConnection;

    private boolean privateParking;

    private boolean minibar;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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

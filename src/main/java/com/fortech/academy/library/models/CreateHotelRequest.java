package com.fortech.academy.library.models;

public class CreateHotelRequest {

    private String hotelName;

    private String hotelLocation;

    private int rating;

    private boolean breakfast;

    private boolean wifiConnection;

    private boolean privateParking;

    private boolean minibar;

    private double latitude;

    private double longitude;

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

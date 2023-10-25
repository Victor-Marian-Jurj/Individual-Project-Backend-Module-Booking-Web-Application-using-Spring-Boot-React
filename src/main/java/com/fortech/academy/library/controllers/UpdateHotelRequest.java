package com.fortech.academy.library.controllers;

public class UpdateHotelRequest {

        private int rating;

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
}

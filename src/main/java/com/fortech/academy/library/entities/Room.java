package com.fortech.academy.library.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "hotel_id")
    private int hotelId;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "room_floor")
    private int roomFloor;

    @Column(name = "room_price")
    private int roomPrice;

    public Room() {
    }

    public Room(int hotelId, int roomNumber, String roomType, int roomFloor, int roomPrice) {
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomFloor = roomFloor;
        this.roomPrice = roomPrice;
    }

    public Long getRoomId() {
        return roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
}

package com.fortech.academy.library.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "card_number")
    private int cardNumber;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "cvc_number")
    private int cvcNumber;

    public Payment(int user_id, String nameOnCard, int cardNumber, Date expirationDate, int cvcNumber) {
        this.user_id = user_id;
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvcNumber = cvcNumber;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvcNumber() {
        return cvcNumber;
    }

    public void setCvcNumber(int cvcNumber) {
        this.cvcNumber = cvcNumber;
    }
}

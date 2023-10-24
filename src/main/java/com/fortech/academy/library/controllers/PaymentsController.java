package com.fortech.academy.library.controllers;


import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.services.PaymentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments")
public class PaymentsController {

    private final PaymentsService paymentsService;


    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping("test")
    public String test() {
        return "It works...";
    }

    @GetMapping
    public List<Payment> readAllPayments() {
        return paymentsService.getAllPayments();
    }

    @PostMapping
    public void createPayment(@RequestBody CreatePaymentRequest requestBody) {
        Payment newPayment = new Payment();
        newPayment.setUserId(requestBody.getUserId());
        newPayment.setNameOnCard(requestBody.getNameOnCard());
        newPayment.setCardNumber(requestBody.getCardNumber());
        newPayment.setExpirationDate(requestBody.getExpirationDate());
        newPayment.setCvcNumber(requestBody.getCvcNumber());
        paymentsService.addPayment(newPayment);
    }
}

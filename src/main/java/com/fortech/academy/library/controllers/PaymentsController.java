package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.services.PaymentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentsController {

    private final PaymentsService paymentsService;

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

    @GetMapping("{id}")
    public ResponseEntity<Payment> readPaymentById(@PathVariable Long id) {
        try {
            Payment responseBody = paymentsService.getBookById(id);
            return ResponseEntity.ok(responseBody);
        } catch
        (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<ReadAllPaymentsResponse> readAllPayments() {
        log.info("readAllPayments");
        List<Payment> payments = paymentsService.getAllPayments();
        ReadAllPaymentsResponse responseBody = new ReadAllPaymentsResponse(payments);
        return ResponseEntity.ok(responseBody);
    }
}


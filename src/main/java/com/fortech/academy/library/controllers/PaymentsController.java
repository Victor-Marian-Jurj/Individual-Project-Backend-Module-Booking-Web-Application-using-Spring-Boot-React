package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.models.CreatePaymentRequest;
import com.fortech.academy.library.models.ReadAllPaymentsResponse;
import com.fortech.academy.library.models.UpdatePaymentRequest;
import com.fortech.academy.library.services.PaymentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public void createPayment(@RequestBody CreatePaymentRequest requestBody, Authentication authentication) {
        log.info("createPayment");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
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
    public ResponseEntity<ReadAllPaymentsResponse> readAllPayments(Authentication authentication) {
        log.info("readAllPayments");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        List<Payment> payments = paymentsService.getAllPayments();
        ReadAllPaymentsResponse responseBody = new ReadAllPaymentsResponse(payments);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePaymentById(Long id, Authentication authentication) {
        try {
            log.info("deletePayment");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            paymentsService.deletePaymentById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Payment> updatePaymentById(@RequestBody UpdatePaymentRequest requestBody, @PathVariable Long id, Authentication authentication) {
        try {
            log.info("updatePayment");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            Payment responseBody = paymentsService.updatePaymentById(id);
            responseBody.setNameOnCard(requestBody.getNameOnCard());
            responseBody.setCardNumber(requestBody.getCardNumber());
            responseBody.setExpirationDate(requestBody.getExpirationDate());
            responseBody.setCvcNumber(requestBody.getCvcNumber());
            paymentsService.updatePaymentById(responseBody.getPaymentId());
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}


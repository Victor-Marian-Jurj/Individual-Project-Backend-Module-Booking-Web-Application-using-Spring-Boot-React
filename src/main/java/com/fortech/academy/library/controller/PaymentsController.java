package com.fortech.academy.library.controller;


import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.service.PaymentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

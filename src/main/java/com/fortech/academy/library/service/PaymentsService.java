package com.fortech.academy.library.service;


import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.repository.PaymentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }


    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();

    }
}

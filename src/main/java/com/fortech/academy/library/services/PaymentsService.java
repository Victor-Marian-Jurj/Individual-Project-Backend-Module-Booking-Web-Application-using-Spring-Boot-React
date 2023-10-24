package com.fortech.academy.library.services;


import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.repositories.PaymentsRepository;
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

    public void addPayment(Payment newPayment) {
        paymentsRepository.save(newPayment);
    }
}

package com.fortech.academy.library.services;


import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.repositories.PaymentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }


    public void addPayment(Payment newPayment) {
        paymentsRepository.save(newPayment);
    }

    public Payment getBookById(Long id) throws NoSuchElementException {
        return paymentsRepository.findById(id).orElseThrow();
    }

    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }
}

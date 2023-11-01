package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.Hotel;
import com.fortech.academy.library.entities.Payment;
import com.fortech.academy.library.repositories.PaymentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    public void addPayment(Payment newPayment) {
        paymentsRepository.save(newPayment);
    }

    public Payment getBookById(Long id) throws NoSuchElementException {
        return paymentsRepository.findById(id).orElseThrow();
    }

    public List<Payment> getAllPayments() {
        log.info("getAllPayments");
        return paymentsRepository.findAll();
    }

    public void deletePaymentById(Long id) {
        paymentsRepository.deleteById(id);
    }

    public Payment updatePaymentById(Long id) {
        Payment payment = paymentsRepository.findById(id).orElseThrow();
        return paymentsRepository.save(payment);
    }
}

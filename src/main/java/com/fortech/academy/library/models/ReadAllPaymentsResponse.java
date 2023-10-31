package com.fortech.academy.library.models;

import com.fortech.academy.library.entities.Payment;

import java.util.ArrayList;
import java.util.List;

public class ReadAllPaymentsResponse {

    private final List<Payment> payments = new ArrayList<>();

    public ReadAllPaymentsResponse () {
    }

    public ReadAllPaymentsResponse (List<Payment> payments) {
        this.payments.addAll(payments);
    }

    public List<Payment> getPayments() {
        return payments;
    }
}

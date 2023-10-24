package com.fortech.academy.library.repositories;

import com.fortech.academy.library.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payment, Long> {
}

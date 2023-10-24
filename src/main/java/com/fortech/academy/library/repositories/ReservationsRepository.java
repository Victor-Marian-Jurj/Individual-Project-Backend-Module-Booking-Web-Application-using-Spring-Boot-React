package com.fortech.academy.library.repositories;

import com.fortech.academy.library.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<Reservation, Long> {
}

package com.fortech.academy.library.repositories;

import com.fortech.academy.library.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelsRepository extends JpaRepository<Hotel, Long> {
}

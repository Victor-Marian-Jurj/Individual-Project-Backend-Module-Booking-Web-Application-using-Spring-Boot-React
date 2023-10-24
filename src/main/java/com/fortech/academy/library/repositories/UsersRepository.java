package com.fortech.academy.library.repositories;

import com.fortech.academy.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}

package com.fortech.academy.library.repository;


import com.fortech.academy.library.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Room, Long> {

}

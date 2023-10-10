package com.fortech.academy.library.service;

import com.fortech.academy.library.entities.User;
import com.fortech.academy.library.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

private final UsersRepository usersRepository;

@Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers() {
      return usersRepository.findAll();
    }
}

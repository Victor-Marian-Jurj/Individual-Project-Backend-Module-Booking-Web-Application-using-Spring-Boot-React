package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.User;
import com.fortech.academy.library.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersService {

private final UsersRepository usersRepository;

@Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void addUser(User newUser) {
    usersRepository.save(newUser);
    }

    public User getUserById(Long id) throws NoSuchElementException {
    return usersRepository.findById(id).orElseThrow();
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
}

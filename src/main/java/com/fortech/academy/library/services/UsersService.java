package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.User;
import com.fortech.academy.library.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {

private final UsersRepository usersRepository;

    public void addUser(User newUser) {
    usersRepository.save(newUser);
    }

    public User getUserById(Long id) throws NoSuchElementException {
    return usersRepository.findById(id).orElseThrow();
    }

    public List<User> getAllUsers() {
        log.info("getAllUsers");
        return usersRepository.findAll();
    }

    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }

    public User updateUserById(Long id) {
        User user = usersRepository.findById(id).orElseThrow();
        return user;
    }
}

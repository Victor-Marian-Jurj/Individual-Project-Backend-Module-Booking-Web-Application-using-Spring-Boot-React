package com.fortech.academy.library.controller;

import com.fortech.academy.library.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    @GetMapping("test")
    public String test() {
        return "It works...";
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> responseBody = new ArrayList<>();
        responseBody.add(new User("Razvan1", "1234", "Petcu", "Razvan", "0744223366", "razvan.petcu@gmail.com"));
        responseBody.add(new User("Marian", "mar12", "Stancu", "Marian", "0743104796", "marian.stancu@gmail.com"));
        responseBody.add(new User("Maria89", "7688", "Vlad", "Maria", "0754963248", "maria.vlad@yahoo.com"));
        return responseBody;
    }
}


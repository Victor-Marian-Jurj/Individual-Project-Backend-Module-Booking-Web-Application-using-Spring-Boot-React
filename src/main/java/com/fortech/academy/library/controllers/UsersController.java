package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.User;
import com.fortech.academy.library.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("test")
    public String test() {
        return "It works...";
    }

    @PostMapping
    public void createUser(@RequestBody CreateUserRequest requestBody) {
        User newUser = new User();
        newUser.setUsername(requestBody.getUsername());
        newUser.setPassword(requestBody.getPassword());
        newUser.setFirstName(requestBody.getFirstName());
        newUser.setLastName(requestBody.getLastName());
        newUser.setPhoneNumber(requestBody.getPhoneNumber());
        newUser.setEmailAddress(requestBody.getEmailAddress());
        usersService.addUser(newUser);
    }

    @GetMapping
    public List<User> readAllUsers() {
        return usersService.getAllUsers();
    }




}


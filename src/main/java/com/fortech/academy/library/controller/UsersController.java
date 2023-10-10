package com.fortech.academy.library.controller;

import com.fortech.academy.library.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }
}


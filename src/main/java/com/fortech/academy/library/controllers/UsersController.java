package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.entities.User;
import com.fortech.academy.library.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("{id}")
    public ResponseEntity<User> readUserById (@PathVariable Long id) {
        try { User responseBody = usersService.getUserById(id);
            return ResponseEntity.ok(responseBody);

        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<ReadAllUsersResponse> readAllUsers() {
        List<User> users = usersService.getAllUsers();
        ReadAllUsersResponse responseBody = new ReadAllUsersResponse(users);
        return ResponseEntity.ok(responseBody);
    }




}


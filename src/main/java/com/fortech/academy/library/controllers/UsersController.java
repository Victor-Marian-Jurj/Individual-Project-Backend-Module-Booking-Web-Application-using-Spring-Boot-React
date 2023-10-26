package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.User;
import com.fortech.academy.library.services.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UsersService usersService;

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
    public ResponseEntity<ReadAllUsersResponse> readAllUsers(Authentication authentication) {
        log.info("readAllUsers");
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        List<User> users = usersService.getAllUsers();
        ReadAllUsersResponse responseBody = new ReadAllUsersResponse(users);
        return ResponseEntity.ok(responseBody);
    }




}


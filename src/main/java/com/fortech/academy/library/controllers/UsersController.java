package com.fortech.academy.library.controllers;

import com.fortech.academy.library.entities.User;
import com.fortech.academy.library.models.CreateUserRequest;
import com.fortech.academy.library.models.ReadAllUsersResponse;
import com.fortech.academy.library.models.UpdateUserRequest;
import com.fortech.academy.library.services.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
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
    public ResponseEntity<User> readUserById(@PathVariable Long id) {
        try {
            User responseBody = usersService.getUserById(id);
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

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, Authentication authentication) {
        try {
            log.info("deleteUser");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            usersService.deleteUserById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<User> updateUserById(@RequestBody UpdateUserRequest requestBody, @PathVariable Long id, Authentication authentication) {
        try {
            log.info("updateUser");
            log.info("authentication = {}", authentication);
            log.info("authentication.getName = {}", authentication.getName());
            User responseBody = usersService.updateUserById(id);
            responseBody.setPassword(requestBody.getPassword());
            responseBody.setFirstName(requestBody.getFirstName());
            responseBody.setLastName(requestBody.getLastName());
            responseBody.setPhoneNumber(requestBody.getPhoneNumber());
            responseBody.setEmailAddress(requestBody.getEmailAddress());
            usersService.updateUserById(responseBody.getUserId());
            return ResponseEntity.ok(responseBody);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

}


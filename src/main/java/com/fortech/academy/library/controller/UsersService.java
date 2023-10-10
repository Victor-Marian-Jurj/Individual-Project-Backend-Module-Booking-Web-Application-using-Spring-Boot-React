package com.fortech.academy.library.controller;

import com.fortech.academy.library.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UsersService {



    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        result.add(new User("Razvan1", "1234", "Petcu", "Razvan", "0744223366", "razvan.petcu@gmail.com"));
        result.add(new User("Marian", "mar12", "Stancu", "Marian", "0743104796", "marian.stancu@gmail.com"));
        result.add(new User("Maria89", "7688", "Vlad", "Maria", "0754963248", "maria.vlad@yahoo.com"));
        return result;
    }
}

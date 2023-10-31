package com.fortech.academy.library.models;

import com.fortech.academy.library.entities.User;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ReadAllUsersResponse {

    private final List<User> users = new ArrayList<>();

    public ReadAllUsersResponse() {
    }

    public ReadAllUsersResponse (List<User> users) {
        this.users.addAll(users);
    }

    public List<User> getUsers() {
        return users;
    }
}

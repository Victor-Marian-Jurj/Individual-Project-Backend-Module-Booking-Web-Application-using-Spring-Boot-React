package com.fortech.academy.library.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ReservationController {

    @GetMapping("test")
    public String test() {
        return "It works...";
    }
}

package com.fortech.academy.library.controller;

import com.fortech.academy.library.controller.service.HotelsService;
import com.fortech.academy.library.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelsController {

    private final HotelsService hotelsService;

    @Autowired
    public HotelsController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    @GetMapping("test")
    public String test(){
        return "It works...";
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelsService.getAllHotels();
    }

}

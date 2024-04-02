package com.fortech.academy.library.controllers;

import com.fortech.academy.library.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {
    @Autowired
    EmailService emailService;

    public EmailController() {
    }

    @GetMapping({"/sendMail/{email}"})
    public String sendEmail(@PathVariable(value = "email",required = true) String email) {
        return this.emailService.sendEmail(email);
    }
}

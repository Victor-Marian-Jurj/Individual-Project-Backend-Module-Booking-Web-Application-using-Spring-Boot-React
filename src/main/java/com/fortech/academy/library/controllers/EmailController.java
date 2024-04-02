package com.fortech.academy.library.controllers;

import com.fortech.academy.library.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping({"/sendMail/{email}"})
    public ResponseEntity<String> sendEmail(@PathVariable(value = "email", required = true) String email) {

        boolean isValidEmail = emailService.isValidEmail(email);
        if (!isValidEmail) {
            // Return HTTP status code 400 (Bad Request) for invalid email
            return ResponseEntity.badRequest().body("Invalid email address");
        }
        // Proceed with sending the email
        boolean emailSent = emailService.sendEmail(email);
        if (emailSent) {
            // Return HTTP status code 200 (OK) for successful email sending
            return ResponseEntity.ok().body("Email sent successfully");
        } else {
            // Return HTTP status code 500 (Internal Server Error) for failed email sending
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
        }
    }
}


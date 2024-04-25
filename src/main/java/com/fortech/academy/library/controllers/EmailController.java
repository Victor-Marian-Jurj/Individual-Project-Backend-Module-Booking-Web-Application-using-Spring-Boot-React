package com.fortech.academy.library.controllers;

import com.fortech.academy.library.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendEmailWithAttachment(
            @RequestParam("email") String email,
            @RequestParam("file") MultipartFile file) {

        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body("Email address is required");
        }

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file attached");
        }

        boolean isValidEmail = emailService.isValidEmail(email);
        if (!isValidEmail) {
            return ResponseEntity.badRequest().body("Invalid email address");
        }

        // Get the file content, name, and type
        byte[] attachmentContent;
        String attachmentFileName;
        String attachmentType;

        try {
            attachmentContent = file.getBytes();
            attachmentFileName = file.getOriginalFilename();
            attachmentType = file.getContentType();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to read file");
        }

        // Send the email with attachment using the EmailService
        boolean emailSent = emailService.sendEmail(email, attachmentContent, attachmentFileName, attachmentType);
        if (emailSent) {
            return ResponseEntity.ok().body("Email sent successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
        }
    }
}

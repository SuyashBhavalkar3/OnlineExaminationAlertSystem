package com.examportal.examportal.controller;

import com.examportal.examportal.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailTestController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/test")
    public String testEmail() {
        // Replace with your test email address
        String to = "avishkarsuryawanshi510@gmail.com";
        String subject = "Test Email";
        String message = "This is a test email from the Exam Portal.";

        emailService.sendMail(to, subject, message);
        return "Test email sent to " + to;
    }
}

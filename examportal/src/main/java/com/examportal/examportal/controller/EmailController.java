package com.examportal.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examportal.service.EmailService;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // ✅ Admin-triggered endpoint to send exam alerts to all students
    @PostMapping("/send-alerts")
    public String triggerEmailAlertsForAll() {
        emailService.sendExamAlertsToAllStudents(); // updated method
        return "Email alerts sent to all students";
    }
    @PostMapping("/notify-absentees")
    public String notifyAbsentees(@RequestParam Long examId) {
        emailService.notifyAbsentees(examId);
        return "Absentee notification triggered for examId: " + examId;
    }
}

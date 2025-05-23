package com.examportal.examportal.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examportal.dto.JoinExamRequest;
import com.examportal.examportal.model.StudentExamStatus;
import com.examportal.examportal.repository.StudentExamStatusRepository;
import com.examportal.examportal.service.EmailService;

@RestController
@RequestMapping("/api/exam-status")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentExamStatusController {

    @Autowired
    private StudentExamStatusRepository statusRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/join")
    public String joinExam(@RequestBody JoinExamRequest request) {
        Long examId = request.getExamId();
        String email = request.getEmail();

        StudentExamStatus status = statusRepository
                .findByExamIdAndStudentEmail(examId, email)
                .orElse(new StudentExamStatus());

        status.setExamId(examId);
        status.setStudentEmail(email);
        status.setJoined(true);
        status.setJoinedAt(LocalDateTime.now());

        statusRepository.save(status);

        emailService.notifyAbsentees(examId);

        return "Exam joined successfully";
    }
}

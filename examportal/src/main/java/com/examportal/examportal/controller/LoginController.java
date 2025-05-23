// com.examportal.examportal.controller.LoginController
package com.examportal.examportal.controller;

import com.examportal.examportal.model.Student_;
import com.examportal.examportal.repository.StudentRepository;
import com.examportal.examportal.service.LoggedInStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LoggedInStudentService loggedInStudentService;

    @PostMapping("/login")
    public Student_ login(@RequestBody Student_ student) {
        Student_ existing = studentRepository.findByEmail(student.getEmail());
        if (existing != null && existing.getPassword().equals(student.getPassword())) {
            loggedInStudentService.setLoggedInEmail(existing.getEmail()); // Store email
            return existing;
        }
        return null;
    }
}

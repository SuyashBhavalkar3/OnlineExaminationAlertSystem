package com.examportal.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examportal.model.Student_;
import com.examportal.examportal.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:5173")  // ✅ Add this line
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/signup")
    public ResponseEntity<Student_> signup(@RequestBody Student_ student) {
        Student_ savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }
}

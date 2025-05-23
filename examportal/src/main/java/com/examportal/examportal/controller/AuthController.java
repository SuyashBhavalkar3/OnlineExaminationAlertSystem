package com.examportal.examportal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examportal.payload.SignInRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // ← this is crucial
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInRequest request) {
        // handle login logic
        return ResponseEntity.ok("Login successful");
    }
}

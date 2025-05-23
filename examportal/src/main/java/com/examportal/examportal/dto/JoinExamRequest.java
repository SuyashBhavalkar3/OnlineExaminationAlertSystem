package com.examportal.examportal.dto;

public class JoinExamRequest {
    private Long examId;
    private String email;

    // Getters and Setters
    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

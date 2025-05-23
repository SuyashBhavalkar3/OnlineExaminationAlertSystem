// ExamReportDTO.java
package com.examportal.examportal.dto;

public class ExamReportDTO {
    private String studentName;
    private String email;
    private String status;

    public ExamReportDTO(String studentName, String email, String status) {
        this.studentName = studentName;
        this.email = email;
        this.status = status;
    }

    // Getters and Setters
}

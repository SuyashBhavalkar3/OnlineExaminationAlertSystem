// package com.examportal.examportal.model;

// import java.time.LocalDateTime;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class StudentExamStatus {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long examId;
//     private String studentEmail;
//     private boolean joined;
//     private LocalDateTime joinedAt;

//     // Getters and setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getExamId() { return examId; }
//     public void setExamId(Long examId) { this.examId = examId; }

//     public String getStudentEmail() { return studentEmail; }
//     public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }

//     public boolean isJoined() { return joined; }
//     public void setJoined(boolean joined) { this.joined = joined; }

//     public LocalDateTime getJoinedAt() { return joinedAt; }
//     public void setJoinedAt(LocalDateTime joinedAt) { this.joinedAt = joinedAt; }
// }

package com.examportal.examportal.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentExamStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long examId;

    private String studentEmail;

    @Column(columnDefinition = "BIT", nullable = false)
    private boolean joined;

    private LocalDateTime joinedAt;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public boolean isJoined() {
        return joined;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }
}

package com.examportal.examportal.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications_sent")
public class NotificationSent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long examId;
    private String studentEmail;

    @Enumerated(EnumType.STRING)
    private NotificationType type; // REMINDER or ABSENT

    private LocalDateTime sentAt;

    // Getters and setters
    public enum NotificationType {
        REMINDER, ABSENT
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }

    public String getStudentEmail() { return studentEmail; }
    public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }

    public NotificationType getType() { return type; }
    public void setType(NotificationType type) { this.type = type; }

    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
}

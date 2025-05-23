package com.examportal.examportal.repository;

import com.examportal.examportal.model.NotificationSent;
import com.examportal.examportal.model.NotificationSent.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationSentRepository extends JpaRepository<NotificationSent, Long> {
    Optional<NotificationSent> findByExamIdAndStudentEmailAndType(Long examId, String studentEmail, NotificationType type);
}

package com.examportal.examportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.examportal.model.StudentExamStatus;

public interface StudentExamStatusRepository extends JpaRepository<StudentExamStatus, Long> {
    Optional<StudentExamStatus> findByExamIdAndStudentEmail(Long examId, String studentEmail);
}

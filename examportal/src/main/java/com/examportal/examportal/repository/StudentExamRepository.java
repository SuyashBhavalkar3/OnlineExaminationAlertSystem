package com.examportal.examportal.repository;

import com.examportal.examportal.model.StudentExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentExamRepository extends JpaRepository<StudentExam, Long> {
    List<StudentExam> findByExamId(Long examId);
}

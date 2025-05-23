// package com.examportal.examportal.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.examportal.examportal.model.Exam_;

// public interface ExamRepository extends JpaRepository<Exam_, Long> {
// }
package com.examportal.examportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.examportal.model.Exam_;

public interface ExamRepository extends JpaRepository<Exam_, Long> {

    // Fetch all exams sorted by exam_date and exam_time (earliest first)
    List<Exam_> findAllByOrderByDateAscTimeAsc();
    List<Exam_> findByStatus(String status);
}

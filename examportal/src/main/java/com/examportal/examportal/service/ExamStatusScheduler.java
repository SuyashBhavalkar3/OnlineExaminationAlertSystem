package com.examportal.examportal.service;

import com.examportal.examportal.model.Exam_;
import com.examportal.examportal.repository.ExamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExamStatusScheduler {

    @Autowired
    private ExamRepository examRepository;

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void updateExamStatuses() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Scheduler running at: " + now);

        List<Exam_> exams = examRepository.findByStatus("Upcoming");

        for (Exam_ exam : exams) {
            if (exam.getDate() != null && exam.getTime() != null) {
                LocalDateTime examStart = LocalDateTime.of(exam.getDate(), exam.getTime());

                if (now.isAfter(examStart.plusMinutes(5))) {
                    exam.setStatus("Completed");
                    examRepository.save(exam);
                    System.out.println("Updated exam to completed: " + exam.getSubject());
                }
            }
        }
    }
}

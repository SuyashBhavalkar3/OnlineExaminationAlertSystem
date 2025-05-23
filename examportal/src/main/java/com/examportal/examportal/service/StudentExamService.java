package com.examportal.examportal.service;

import com.examportal.examportal.model.StudentExam;
import com.examportal.examportal.repository.StudentExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentExamService {

    @Autowired
    private StudentExamRepository studentExamRepository;

    public List<StudentExam> getExamReport(Long examId) {
        return studentExamRepository.findByExamId(examId);
    }
}

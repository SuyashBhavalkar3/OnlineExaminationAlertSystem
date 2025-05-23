// package com.examportal.examportal.controller;

// import com.examportal.examportal.model.Exam_;
// import com.examportal.examportal.repository.ExamRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @CrossOrigin(origins = "http://localhost:5173")
// @RestController
// @RequestMapping("/api/exams")
// public class ExamController {

//     @Autowired
//     private ExamRepository examRepository;

//     @GetMapping
//     public List<Exam_> getAllExams() {
//         return examRepository.findAll();
//     }
// }

// package com.examportal.examportal.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.examportal.examportal.model.Exam_;
// import com.examportal.examportal.repository.ExamRepository;

// @CrossOrigin(origins = "http://localhost:5173")
// @RestController
// @RequestMapping("/api/exams")
// public class ExamController {

//     @Autowired
//     private ExamRepository examRepository;

//     @GetMapping
//     public List<Exam_> getAllExams() {
//         // Fetch exams sorted by date and time (ascending)
//         return examRepository.findAllByOrderByDateAscTimeAsc();
//     }
// }

package com.examportal.examportal.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examportal.model.Exam_;
import com.examportal.examportal.repository.ExamRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping
    public List<Exam_> getAllExams() {
        List<Exam_> exams = examRepository.findAllByOrderByDateAscTimeAsc();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        for (Exam_ exam : exams) {
            if (
                exam.getDate().isBefore(today) ||
                (exam.getDate().isEqual(today) && exam.getTime().isBefore(now))
            ) {
                exam.setStatus("Completed");  // ✅ Update status
                examRepository.save(exam);   // ✅ Save back to DB
            }
        }

        return exams;
    }
}

// package com.examportal.examportal.controller;

// import com.examportal.examportal.model.StudentExam;
// import com.examportal.examportal.service.StudentExamService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/admin")
// @CrossOrigin(origins = "http://localhost:3000")
// public class StudentExamController {

//     @Autowired
//     private StudentExamService studentExamService;

//     @GetMapping("/exams/{examId}/report")
//     public List<StudentExam> getExamReport(@PathVariable Long examId) {
//         return studentExamService.getExamReport(examId);
//     }
// }

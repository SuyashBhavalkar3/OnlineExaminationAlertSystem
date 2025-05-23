// package com.examportal.examportal.controller;

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.examportal.examportal.model.Admin;
// import com.examportal.examportal.model.Exam_;
// import com.examportal.examportal.model.Student_;
// import com.examportal.examportal.repository.AdminRepository;
// import com.examportal.examportal.repository.ExamRepository;
// import com.examportal.examportal.repository.StudentRepository;
// import com.examportal.examportal.service.EmailService;

// @RestController
// @RequestMapping("/api/admin")
// @CrossOrigin(origins = "http://localhost:5173")
// public class AdminController {

//     @Autowired
//     private AdminRepository adminRepository;

//     @Autowired
//     private ExamRepository examRepository;

//     @Autowired
//     private StudentRepository studentRepository;

//     @Autowired
//     private EmailService emailService;

//     // ✅ Admin Signup
//     @PostMapping("/signup")
//     public String registerAdmin(@RequestBody Admin admin) {
//         if (adminRepository.existsByEmail(admin.getEmail()) || adminRepository.existsByGrNo(admin.getGrNo())) {
//             return "Admin already exists with this email or GR number.";
//         }
//         adminRepository.save(admin);
//         return "Admin registered successfully.";
//     }

//     // ✅ Admin Login
//     @PostMapping("/login")
//     public String loginAdmin(@RequestBody Admin loginData) {
//         Admin admin = adminRepository.findByEmail(loginData.getEmail());
//         if (admin != null && admin.getPassword().equals(loginData.getPassword())) {
//             return "Login successful";
//         } else {
//             return "Invalid email or password";
//         }
//     }

//     // ✅ Get all exams (used for displaying in admin dashboard)
//     @GetMapping("/exams")
//     public List<Exam_> getAllExams() {
//         return examRepository.findAll();
//     }

//     // ✅ Trigger email to all students for a specific exam
//     @PostMapping("/exams/{examId}/notify")
// public ResponseEntity<String> triggerExamEmail(@PathVariable Long examId) {
//     Optional<Exam_> examOpt = examRepository.findById(examId);
//     if (examOpt.isEmpty()) {
//         return ResponseEntity.notFound().build();
//     }

//     Exam_ exam = examOpt.get();
//     List<Student_> students = studentRepository.findAll();

//     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//     DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

//     LocalDate examDate = exam.getDate();  // <-- Use local variable to inspect if needed
//     LocalTime examTime = exam.getTime();

//     String formattedDate = examDate != null ? examDate.format(dateFormatter) : "N/A";
//     String formattedTime = examTime != null ? examTime.format(timeFormatter) : "N/A";

//     for (Student_ student : students) {
//         String message = String.format(
//             "Dear %s,\n\nYou have an upcoming exam:\nSubject: %s\nDate: %s\nTime: %s\n\nPlease be prepared.",
//             student.getName(),
//             exam.getSubject(),
//             formattedDate,
//             formattedTime
//         );

//         emailService.sendMail(student.getEmail(), "Upcoming Exam Notification", message);
//     }

//     return ResponseEntity.ok("Emails sent to all students for exam: " + exam.getSubject());
// }
// }


// package com.examportal.examportal.controller;

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.examportal.examportal.model.Admin;
// import com.examportal.examportal.model.Exam_;
// import com.examportal.examportal.model.Student_;
// import com.examportal.examportal.repository.AdminRepository;
// import com.examportal.examportal.repository.ExamRepository;
// import com.examportal.examportal.repository.StudentRepository;
// import com.examportal.examportal.service.EmailService;

// @RestController
// @RequestMapping("/api/admin")
// @CrossOrigin(origins = "http://localhost:5173")
// public class AdminController {

//     @Autowired
//     private AdminRepository adminRepository;

//     @Autowired
//     private ExamRepository examRepository;

//     @Autowired
//     private StudentRepository studentRepository;

//     @Autowired
//     private EmailService emailService;

//     // ✅ Admin Signup
//     @PostMapping("/signup")
//     public String registerAdmin(@RequestBody Admin admin) {
//         if (adminRepository.existsByEmail(admin.getEmail()) || adminRepository.existsByGrNo(admin.getGrNo())) {
//             return "Admin already exists with this email or GR number.";
//         }
//         adminRepository.save(admin);
//         return "Admin registered successfully.";
//     }

//     // ✅ Admin Login
//     @PostMapping("/login")
//     public String loginAdmin(@RequestBody Admin loginData) {
//         Admin admin = adminRepository.findByEmail(loginData.getEmail());
//         if (admin != null && admin.getPassword().equals(loginData.getPassword())) {
//             return "Login successful";
//         } else {
//             return "Invalid email or password";
//         }
//     }

//     // ✅ Get all exams
//     @GetMapping("/exams")
//     public List<Exam_> getAllExams() {
//         return examRepository.findAll();
//     }

//     // ✅ Trigger email to all students for a specific exam
//     @PostMapping("/exams/{examId}/notify")
//     public ResponseEntity<String> triggerExamEmail(@PathVariable Long examId) {
//         Optional<Exam_> examOpt = examRepository.findById(examId);
//         if (examOpt.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }

//         Exam_ exam = examOpt.get();
//         List<Student_> students = studentRepository.findAll();

//         DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//         DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

//         LocalDate examDate = exam.getDate();
//         LocalTime examTime = exam.getTime();

//         String formattedDate = examDate != null ? examDate.format(dateFormatter) : "N/A";
//         String formattedTime = examTime != null ? examTime.format(timeFormatter) : "N/A";

//         for (Student_ student : students) {
//             String message = String.format(
//                 "Dear %s,\n\nYou have an upcoming exam:\nSubject: %s\nDate: %s\nTime: %s\n\nPlease be prepared.",
//                 student.getName(),
//                 exam.getSubject(),
//                 formattedDate,
//                 formattedTime
//             );
//             emailService.sendMail(student.getEmail(), "Upcoming Exam Notification", message);
//         }

//         return ResponseEntity.ok("Emails sent to all students for exam: " + exam.getSubject());
//     }

//     // ✅ New: Get report of students who joined a particular exam
//     @GetMapping("/exams/{examId}/report")
//     public ResponseEntity<List<Student_>> getExamReport(@PathVariable Long examId) {
//         List<Student_> students = studentRepository.findByJoinedExamsId(examId);
//         if (students.isEmpty()) {
//             return ResponseEntity.noContent().build();
//         }
//         return ResponseEntity.ok(students);
//     }
// }


// package com.examportal.examportal.controller;

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.examportal.examportal.model.Admin;
// import com.examportal.examportal.model.Exam_;
// import com.examportal.examportal.model.Student_;
// import com.examportal.examportal.repository.AdminRepository;
// import com.examportal.examportal.repository.ExamRepository;
// import com.examportal.examportal.repository.StudentRepository;
// import com.examportal.examportal.service.EmailService;

// @RestController
// @RequestMapping("/api/admin")
// @CrossOrigin(origins = "http://localhost:5173")
// public class AdminController {

//     @Autowired
//     private AdminRepository adminRepository;

//     @Autowired
//     private ExamRepository examRepository;

//     @Autowired
//     private StudentRepository studentRepository;

//     @Autowired
//     private EmailService emailService;

//     // ✅ Admin Signup
//     @PostMapping("/signup")
//     public String registerAdmin(@RequestBody Admin admin) {
//         if (adminRepository.existsByEmail(admin.getEmail()) || adminRepository.existsByGrNo(admin.getGrNo())) {
//             return "Admin already exists with this email or GR number.";
//         }
//         adminRepository.save(admin);
//         return "Admin registered successfully.";
//     }

//     // ✅ Admin Login
//     @PostMapping("/login")
//     public String loginAdmin(@RequestBody Admin loginData) {
//         Admin admin = adminRepository.findByEmail(loginData.getEmail());
//         if (admin != null && admin.getPassword().equals(loginData.getPassword())) {
//             return "Login successful";
//         } else {
//             return "Invalid email or password";
//         }
//     }

//     // ✅ Get all exams
//     @GetMapping("/exams")
//     public List<Exam_> getAllExams() {
//         return examRepository.findAll();
//     }

//     // ✅ Add new exam
//     @PostMapping("/exams")
//     public ResponseEntity<String> addExam(@RequestBody Exam_ exam) {
//         if (exam.getSubject() == null || exam.getDate() == null || exam.getTime() == null) {
//             return ResponseEntity.badRequest().body("Subject, Date, and Time are required.");
//         }
//         exam.setStatus("Upcoming"); // Default status
//         examRepository.save(exam);
//         return ResponseEntity.ok("Exam added successfully.");
//     }

//     // ✅ Trigger email to all students for a specific exam
//     @PostMapping("/exams/{examId}/notify")
//     public ResponseEntity<String> triggerExamEmail(@PathVariable Long examId) {
//         Optional<Exam_> examOpt = examRepository.findById(examId);
//         if (examOpt.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }

//         Exam_ exam = examOpt.get();
//         List<Student_> students = studentRepository.findAll();

//         DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//         DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

//         LocalDate examDate = exam.getDate();
//         LocalTime examTime = exam.getTime();

//         String formattedDate = examDate != null ? examDate.format(dateFormatter) : "N/A";
//         String formattedTime = examTime != null ? examTime.format(timeFormatter) : "N/A";

//         for (Student_ student : students) {
//             String message = String.format(
//                 "Dear %s,\n\nYou have an upcoming exam:\nSubject: %s\nDate: %s\nTime: %s\n\nPlease be prepared.",
//                 student.getName(),
//                 exam.getSubject(),
//                 formattedDate,
//                 formattedTime
//             );
//             emailService.sendMail(student.getEmail(), "Upcoming Exam Notification", message);
//         }

//         return ResponseEntity.ok("Emails sent to all students for exam: " + exam.getSubject());
//     }

//     // ✅ Get report of students who joined a particular exam
//     @GetMapping("/exams/{examId}/report")
//     public ResponseEntity<List<Student_>> getExamReport(@PathVariable Long examId) {
//         List<Student_> students = studentRepository.findByJoinedExamsId(examId);
//         if (students.isEmpty()) {
//             return ResponseEntity.noContent().build();
//         }
//         return ResponseEntity.ok(students);
//     }
// }


package com.examportal.examportal.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.examportal.model.Admin;
import com.examportal.examportal.model.Exam_;
import com.examportal.examportal.model.Student_;
import com.examportal.examportal.repository.AdminRepository;
import com.examportal.examportal.repository.ExamRepository;
import com.examportal.examportal.repository.StudentRepository;
import com.examportal.examportal.service.EmailService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmailService emailService;

    // ✅ Admin Signup
    @PostMapping("/signup")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        if (adminRepository.existsByEmail(admin.getEmail()) || adminRepository.existsByGrNo(admin.getGrNo())) {
            return ResponseEntity.badRequest().body("Admin already exists with this email or GR number.");
        }
        adminRepository.save(admin);
        return ResponseEntity.ok("Admin registered successfully.");
    }

    // ✅ Admin Login
    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody Admin loginData) {
        Admin admin = adminRepository.findByEmail(loginData.getEmail());
        if (admin != null && admin.getPassword().equals(loginData.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    // ✅ Get all exams
    @GetMapping("/exams")
    public ResponseEntity<List<Exam_>> getAllExams() {
        List<Exam_> exams = examRepository.findAll();
        return ResponseEntity.ok(exams);
    }

    // ✅ Add a new exam
    @PostMapping("/exams")
    public ResponseEntity<String> addExam(@RequestBody Exam_ exam) {
        if (exam.getSubject() == null || exam.getDate() == null || exam.getTime() == null) {
            return ResponseEntity.badRequest().body("Subject, Date, and Time are required.");
        }
        exam.setStatus("Upcoming");
        examRepository.save(exam);
        return ResponseEntity.ok("Exam added successfully.");
    }

    // ✅ Trigger email notifications for a specific exam
    @PostMapping("/exams/{examId}/notify")
    public ResponseEntity<String> triggerExamEmail(@PathVariable Long examId) {
        Optional<Exam_> examOpt = examRepository.findById(examId);
        if (examOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Exam_ exam = examOpt.get();
        List<Student_> students = studentRepository.findAll();

        LocalDate examDate = exam.getDate();
        LocalTime examTime = exam.getTime();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        String formattedDate = examDate != null ? examDate.format(dateFormatter) : "N/A";
        String formattedTime = examTime != null ? examTime.format(timeFormatter) : "N/A";

        for (Student_ student : students) {
            String message = String.format(
                "Dear %s,\n\nYou have an upcoming exam:\n\nSubject: %s\nDate: %s\nTime: %s\n\nPlease be prepared.\n\nBest regards,\nExam Portal",
                student.getName(),
                exam.getSubject(),
                formattedDate,
                formattedTime
            );
            emailService.sendMail(student.getEmail(), "Upcoming Exam Notification", message);
        }

        return ResponseEntity.ok("Emails sent to all students for exam: " + exam.getSubject());
    }

    // ✅ Get exam by ID
    @GetMapping("/exams/{examId}")
    public ResponseEntity<Exam_> getExamById(@PathVariable Long examId) {
        Optional<Exam_> examOpt = examRepository.findById(examId);
        if (examOpt.isPresent()) {
            return ResponseEntity.ok(examOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    // ✅ Get report: students who joined a particular exam
    @GetMapping("/exams/{examId}/report")
    public ResponseEntity<List<Student_>> getExamReport(@PathVariable Long examId) {
        List<Student_> students = studentRepository.findByJoinedExamsId(examId);
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }
}

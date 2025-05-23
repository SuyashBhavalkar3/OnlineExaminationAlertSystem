// package com.examportal.examportal.service;

// import java.time.Duration;
// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;

// import com.examportal.examportal.model.Exam_;
// import com.examportal.examportal.model.Student_;
// import com.examportal.examportal.repository.ExamRepository;
// import com.examportal.examportal.repository.StudentRepository;

// @Service
// public class EmailService {

//     @Autowired
//     private JavaMailSender mailSender;

//     @Autowired
//     private ExamRepository examRepository;

//     @Autowired
//     private StudentRepository studentRepository;

//     // ✅ Called manually from admin controller
//     public void sendExamAlertsToAllStudents() {
//         List<Exam_> exams = examRepository.findAll();
//         List<Student_> students = studentRepository.findAll();

//         LocalDateTime now = LocalDateTime.now();

//         for (Exam_ exam : exams) {
//             if (!exam.getStatus().equalsIgnoreCase("Upcoming")) continue;

//             LocalDateTime examTime = LocalDateTime.of(exam.getDate(), exam.getTime());
//             long minutes = Duration.between(now, examTime).toMinutes();

//             if (minutes == 10 || minutes == 0) {
//                 for (Student_ student : students) {
//                     sendMail(
//                         student.getEmail(),
//                         "Exam Alert - " + exam.getSubject(),
//                         minutes == 10
//                             ? "Reminder: Your " + exam.getSubject() + " exam starts in 10 minutes."
//                             : "Alert: Your " + exam.getSubject() + " exam is starting now!"
//                     );
//                 }
//             }
//         }
//     }

//     public void sendMail(String to, String subject, String text) {
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setFrom("bhavalkar.suyash232@vit.edu"); // ✅ Set your valid sender email here
//         message.setTo(to);
//         message.setSubject(subject);
//         message.setText(text);
//         mailSender.send(message);
//     }
// }

// package com.examportal.examportal.service;

// import java.time.Duration;
// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;

// import com.examportal.examportal.model.Exam_;
// import com.examportal.examportal.model.StudentExamStatus;
// import com.examportal.examportal.model.Student_;
// import com.examportal.examportal.repository.ExamRepository;
// import com.examportal.examportal.repository.StudentExamStatusRepository;
// import com.examportal.examportal.repository.StudentRepository;

// @Service
// public class EmailService {

//     @Autowired
//     private JavaMailSender mailSender;

//     @Autowired
//     private ExamRepository examRepository;

//     @Autowired
//     private StudentRepository studentRepository;

//     @Autowired
//     private StudentExamStatusRepository studentExamStatusRepository;

//     // ✅ Called manually from admin controller or scheduler
//     public void sendExamAlertsToAllStudents() {
//         List<Exam_> exams = examRepository.findAll();
//         List<Student_> students = studentRepository.findAll();

//         LocalDateTime now = LocalDateTime.now();

//         for (Exam_ exam : exams) {
//             if (!exam.getStatus().equalsIgnoreCase("Upcoming")) continue;

//             LocalDateTime examTime = LocalDateTime.of(exam.getDate(), exam.getTime());
//             long minutes = Duration.between(now, examTime).toMinutes();

//             // ✅ 10 minutes before: notify everyone
//             if (minutes == 10) {
//                 for (Student_ student : students) {
//                     sendMail(
//                         student.getEmail(),
//                         "Exam Alert - " + exam.getSubject(),
//                         "Reminder: Your " + exam.getSubject() + " exam starts in 10 minutes."
//                     );
//                 }
//             }

//             // ✅ 0 minutes: notify only students who have not joined
//             else if (minutes == 0) {
//                 for (Student_ student : students) {
//                     boolean hasJoined = studentExamStatusRepository
//                         .findByExamIdAndStudentEmail(exam.getId(), student.getEmail())
//                         .map(StudentExamStatus::isJoined)
//                         .orElse(false);

//                     if (!hasJoined) {
//                         sendMail(
//                             student.getEmail(),
//                             "Exam Started - " + exam.getSubject(),
//                             "Alert: Your " + exam.getSubject() + " exam has started! Please join immediately."
//                         );
//                     }
//                 }
//             }
//         }
//     }

//     public void sendMail(String to, String subject, String text) {
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setFrom("bhavalkar.suyash232@vit.edu"); // ✅ Use your valid sender email
//         message.setTo(to);
//         message.setSubject(subject);
//         message.setText(text);
//         mailSender.send(message);
//     }
// }


package com.examportal.examportal.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.examportal.examportal.model.Exam_;
import com.examportal.examportal.model.StudentExamStatus;
import com.examportal.examportal.model.Student_;
import com.examportal.examportal.repository.ExamRepository;
import com.examportal.examportal.repository.StudentExamStatusRepository;
import com.examportal.examportal.repository.StudentRepository;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentExamStatusRepository studentExamStatusRepository;

    // ✅ Used by admin controller or scheduler
    public void sendExamAlertsToAllStudents() {
        List<Exam_> exams = examRepository.findAll();
        List<Student_> students = studentRepository.findAll();

        LocalDateTime now = LocalDateTime.now();

        for (Exam_ exam : exams) {
            if (!exam.getStatus().equalsIgnoreCase("Upcoming")) continue;

            LocalDateTime examTime = LocalDateTime.of(exam.getDate(), exam.getTime());
            long minutes = Duration.between(now, examTime).toMinutes();

            if (minutes == 10) {
                for (Student_ student : students) {
                    sendMail(
                        student.getEmail(),
                        "Exam Alert - " + exam.getSubject(),
                        "Reminder: Your " + exam.getSubject() + " exam starts in 10 minutes."
                    );
                }
            } else if (minutes == 0) {
                for (Student_ student : students) {
                    boolean hasJoined = studentExamStatusRepository
                        .findByExamIdAndStudentEmail(exam.getId(), student.getEmail())
                        .map(StudentExamStatus::isJoined)
                        .orElse(false);

                    if (!hasJoined) {
                        sendMail(
                            student.getEmail(),
                            "Exam Started - " + exam.getSubject(),
                            "Alert: Your " + exam.getSubject() + " exam has started! Please join immediately."
                        );
                    }
                }
            }
        }
    }

    // ✅ Used in StudentExamStatusController to notify absentees dynamically
    public void notifyAbsentees(Long examId) {
        Exam_ exam = examRepository.findById(examId).orElse(null);
        if (exam == null || !exam.getStatus().equalsIgnoreCase("Upcoming")) return;

        List<Student_> students = studentRepository.findAll();

        for (Student_ student : students) {
            boolean hasJoined = studentExamStatusRepository
                .findByExamIdAndStudentEmail(examId, student.getEmail())
                .map(StudentExamStatus::isJoined)
                .orElse(false);

            if (!hasJoined) {
                sendMail(
                    student.getEmail(),
                    "Exam Started - " + exam.getSubject(),
                    "Reminder: Your " + exam.getSubject() + " exam has started. Please join if you haven’t yet."
                );
            }
        }
    }

    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bhavalkar.suyash232@vit.edu"); // ✅ Use your actual email here
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}

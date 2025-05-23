// package com.examportal.examportal.service;

// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Service;

// import com.examportal.examportal.model.Exam_;
// import com.examportal.examportal.model.NotificationSent;
// import com.examportal.examportal.model.NotificationSent.NotificationType;
// import com.examportal.examportal.model.Student_;
// import com.examportal.examportal.repository.ExamRepository;
// import com.examportal.examportal.repository.NotificationSentRepository;
// import com.examportal.examportal.repository.StudentRepository;

// @Service
// public class ExamSchedulerService {

//     @Autowired
//     private EmailService emailService;

//     @Autowired
//     private NotificationSentRepository notificationSentRepository;

//     @Autowired
//     private StudentRepository studentRepository;

//     @Autowired
//     private ExamRepository examRepository;

//     @Scheduled(fixedRate = 60000)  // Run every minute
//     public void checkExamTimings() {
//         List<Exam_> exams = examRepository.findAll();
//         LocalDateTime now = LocalDateTime.now();

//         for (Exam_ exam : exams) {
//             LocalDateTime examDateTime = LocalDateTime.of(exam.getDate(), exam.getTime());

//             // 10 minutes before the exam
//             if (now.isAfter(examDateTime.minusMinutes(10)) && now.isBefore(examDateTime.minusMinutes(9))) {
//                 sendReminderEmails(exam);
//             }

//             // At the exact time of the exam
//             if (now.isAfter(examDateTime) && now.isBefore(examDateTime.plusMinutes(1))) {
//                 sendAbsentEmails(exam);
//             }
//         }
//     }

//     private void sendReminderEmails(Exam_ exam) {
//         List<Student_> students = studentRepository.findAll();
//         for (Student_ student : students) {
//             boolean alreadySent = notificationSentRepository
//                 .findByExamIdAndStudentEmailAndType(exam.getId(), student.getEmail(), NotificationType.REMINDER)
//                 .isPresent();

//             if (!alreadySent) {
//                 emailService.sendMail(
//                     student.getEmail(),
//                     "Reminder: " + exam.getSubject() + " Exam in 10 Minutes",
//                     "Hi " + student.getName() + ",\n\nYour " + exam.getSubject() + " exam starts in 10 minutes.\nDate: " + exam.getDate() + "\nTime: " + exam.getTime() + "\n\nPlease be prepared."
//                 );

//                 NotificationSent sent = new NotificationSent();
//                 sent.setExamId(exam.getId());
//                 sent.setStudentEmail(student.getEmail());
//                 sent.setType(NotificationType.REMINDER);
//                 sent.setSentAt(LocalDateTime.now());
//                 notificationSentRepository.save(sent);
//             }
//         }
//     }

//     private void sendAbsentEmails(Exam_ exam) {
//         List<Student_> students = studentRepository.findAll();
//         for (Student_ student : students) {
//             boolean alreadySent = notificationSentRepository
//                 .findByExamIdAndStudentEmailAndType(exam.getId(), student.getEmail(), NotificationType.ABSENT)
//                 .isPresent();

//             if (!alreadySent) {
//                 emailService.sendMail(
//                     student.getEmail(),
//                     "Missed Exam Alert: " + exam.getSubject(),
//                     "Hi " + student.getName() + ",\n\nYou have missed the " + exam.getSubject() + " exam.\nDate: " + exam.getDate() + "\nTime: " + exam.getTime() + "\n\nPlease contact the admin for clarification."
//                 );

//                 NotificationSent sent = new NotificationSent();
//                 sent.setExamId(exam.getId());
//                 sent.setStudentEmail(student.getEmail());
//                 sent.setType(NotificationType.ABSENT);
//                 sent.setSentAt(LocalDateTime.now());
//                 notificationSentRepository.save(sent);
//             }
//         }
//     }
// }


package com.examportal.examportal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.examportal.examportal.model.Exam_;
import com.examportal.examportal.model.NotificationSent;
import com.examportal.examportal.model.NotificationSent.NotificationType;
import com.examportal.examportal.model.StudentExamStatus;
import com.examportal.examportal.model.Student_;
import com.examportal.examportal.repository.ExamRepository;
import com.examportal.examportal.repository.NotificationSentRepository;
import com.examportal.examportal.repository.StudentExamStatusRepository;
import com.examportal.examportal.repository.StudentRepository;

@Service
public class ExamSchedulerService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private NotificationSentRepository notificationSentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentExamStatusRepository studentExamStatusRepository;

    @Scheduled(fixedRate = 60000)  // Run every minute
    public void checkExamTimings() {
        List<Exam_> exams = examRepository.findAll();
        LocalDateTime now = LocalDateTime.now();

        for (Exam_ exam : exams) {
            LocalDateTime examDateTime = LocalDateTime.of(exam.getDate(), exam.getTime());

            // 10 minutes before the exam
            if (now.isAfter(examDateTime.minusMinutes(10)) && now.isBefore(examDateTime.minusMinutes(9))) {
                sendReminderEmails(exam);
            }

            // At the exact time of the exam
            if (now.isAfter(examDateTime) && now.isBefore(examDateTime.plusMinutes(1))) {
                sendAbsentEmails(exam);
            }
        }
    }

    private void sendReminderEmails(Exam_ exam) {
        List<Student_> students = studentRepository.findAll();
        for (Student_ student : students) {
            boolean alreadySent = notificationSentRepository
                .findByExamIdAndStudentEmailAndType(exam.getId(), student.getEmail(), NotificationType.REMINDER)
                .isPresent();

            if (!alreadySent) {
                emailService.sendMail(
                    student.getEmail(),
                    "Reminder: " + exam.getSubject() + " Exam in 10 Minutes",
                    "Hi " + student.getName() + ",\n\nYour " + exam.getSubject() + " exam starts in 10 minutes.\nDate: " + exam.getDate() + "\nTime: " + exam.getTime() + "\n\nPlease be prepared."
                );

                NotificationSent sent = new NotificationSent();
                sent.setExamId(exam.getId());
                sent.setStudentEmail(student.getEmail());
                sent.setType(NotificationType.REMINDER);
                sent.setSentAt(LocalDateTime.now());
                notificationSentRepository.save(sent);
            }
        }
    }

    private void sendAbsentEmails(Exam_ exam) {
        List<Student_> students = studentRepository.findAll();

        for (Student_ student : students) {
            boolean alreadySent = notificationSentRepository
                .findByExamIdAndStudentEmailAndType(exam.getId(), student.getEmail(), NotificationType.ABSENT)
                .isPresent();

            boolean hasJoined = studentExamStatusRepository
                .findByExamIdAndStudentEmail(exam.getId(), student.getEmail())
                .map(StudentExamStatus::isJoined)
                .orElse(false);

            if (!alreadySent && !hasJoined) {
                emailService.sendMail(
                    student.getEmail(),
                    "Exam Started: " + exam.getSubject(),
                    "Hi " + student.getName() + ",\n\nYour " + exam.getSubject() + " exam has started.\nDate: " + exam.getDate() + "\nTime: " + exam.getTime() + "\n\nPlease join the exam immediately."
                );

                NotificationSent sent = new NotificationSent();
                sent.setExamId(exam.getId());
                sent.setStudentEmail(student.getEmail());
                sent.setType(NotificationType.ABSENT);
                sent.setSentAt(LocalDateTime.now());
                notificationSentRepository.save(sent);
            }
        }
    }
}

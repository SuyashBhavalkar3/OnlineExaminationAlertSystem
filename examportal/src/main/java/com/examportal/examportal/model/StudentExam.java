package com.examportal.examportal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_exam")
public class StudentExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student_ student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam_ exam;

    @Column(nullable = false)
    private boolean attended;

    private Integer marks; // optional: can be null if not applicable

    // Constructors
    public StudentExam() {
    }

    public StudentExam(Student_ student, Exam_ exam, boolean attended, Integer marks) {
        this.student = student;
        this.exam = exam;
        this.attended = attended;
        this.marks = marks;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student_ getStudent() {
        return student;
    }

    public void setStudent(Student_ student) {
        this.student = student;
    }

    public Exam_ getExam() {
        return exam;
    }

    public void setExam(Exam_ exam) {
        this.exam = exam;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}

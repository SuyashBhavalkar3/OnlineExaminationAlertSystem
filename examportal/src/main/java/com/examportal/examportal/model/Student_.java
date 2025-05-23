// package com.examportal.examportal.model;

// import jakarta.persistence.*;

// @Entity
// public class Student_ {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private String email;
//     private String password;
//     private String prn;

// public String getPrn() {
//     return prn;
// }
// public void setPrn(String prn) {
//     this.prn = prn;
// }

//     // Getters and setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
// }


package com.examportal.examportal.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student_ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String prn;

    @ManyToMany
    @JoinTable(
        name = "student_exam",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "exam_id")
    )
    private List<Exam_> joinedExams;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPrn() { return prn; }
    public void setPrn(String prn) { this.prn = prn; }

    public List<Exam_> getJoinedExams() { return joinedExams; }
    public void setJoinedExams(List<Exam_> joinedExams) { this.joinedExams = joinedExams; }
}

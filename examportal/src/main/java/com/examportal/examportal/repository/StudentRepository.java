// package com.examportal.examportal.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.examportal.examportal.model.Student_;

// @Repository
// public interface StudentRepository extends JpaRepository<Student_, Long> {

//     // Optional: custom finder
//     Student_ findByEmail(String email);
// }


package com.examportal.examportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.examportal.model.Student_;

@Repository
public interface StudentRepository extends JpaRepository<Student_, Long> {

    // For login
    Student_ findByEmail(String email);

    // ✅ For fetching students who joined a specific exam
    //List<Student_> findByJoinedExamId(Long examId);
    List<Student_> findByJoinedExamsId(Long examId);

}

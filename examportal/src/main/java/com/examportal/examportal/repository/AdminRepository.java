package com.examportal.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.examportal.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByGrNo(String grNo);
}

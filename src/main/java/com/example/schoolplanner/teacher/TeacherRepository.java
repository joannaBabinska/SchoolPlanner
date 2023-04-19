package com.example.schoolplanner.teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    boolean existsByEmail(String email);

    List<Teacher> findAll();


}
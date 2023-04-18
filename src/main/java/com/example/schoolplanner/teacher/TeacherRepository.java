package com.example.schoolplanner.teacher;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {

    boolean existsByEmail(String email);

    List<Teacher> findAll();


}

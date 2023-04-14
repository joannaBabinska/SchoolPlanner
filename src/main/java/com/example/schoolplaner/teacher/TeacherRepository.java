package com.example.schoolplaner.teacher;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {

    Optional<Teacher> findAllByEmail(String email);
}

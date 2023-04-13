package com.example.schoolplaner.teacher;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }
}

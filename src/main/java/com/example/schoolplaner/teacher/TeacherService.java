package com.example.schoolplaner.teacher;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherService {

    private final  TeacherRepository teacherRepository;
}

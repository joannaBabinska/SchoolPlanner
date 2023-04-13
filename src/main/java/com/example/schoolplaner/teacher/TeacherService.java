package com.example.schoolplaner.teacher;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

   TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(TeacherNotFoundException::new);
        return TeacherDtoMapper.map(teacher);

    }

    TeacherDto saveTeacher(TeacherDto teacherDto) {
        Teacher teacher = TeacherDtoMapper.map(teacherDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherDtoMapper.map(savedTeacher);
    }
}

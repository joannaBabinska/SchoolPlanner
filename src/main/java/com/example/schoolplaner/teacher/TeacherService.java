package com.example.schoolplaner.teacher;

import com.example.schoolplaner.teacher.exception.EmailExistException;
import com.example.schoolplaner.teacher.exception.TeacherNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(TeacherNotFoundException::new);
        return TeacherDtoMapper.map(teacher);

    }

    TeacherDto saveTeacher(TeacherRegistrationDto teacherRegistrationDto) {
        Teacher teacher = TeacherDtoMapper.map(teacherRegistrationDto);
        boolean emailExist = teacherRepository.findAllByEmail(teacher.getEmail())
                .isEmpty();
        if (!emailExist) {
            throw new EmailExistException();
        } else {
            Teacher savedTeacher = teacherRepository.save(teacher);
            return TeacherDtoMapper.map(savedTeacher);
        }
    }

}


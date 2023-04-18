package com.example.schoolplanner.teacher;

import com.example.schoolplanner.teacher.dto.TeacherDto;
import com.example.schoolplanner.teacher.dto.TeacherDtoMapper;
import com.example.schoolplanner.teacher.dto.TeacherRegistrationDto;
import com.example.schoolplanner.teacher.exception.EmailExistException;
import com.example.schoolplanner.teacher.exception.TeacherNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;

    TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
        return TeacherDtoMapper.map(teacher);
    }

    TeacherDto saveTeacher(TeacherRegistrationDto teacherRegistrationDto) {
        if (emailIsAlreadyTaken(teacherRegistrationDto)) {
            throw new EmailExistException(teacherRegistrationDto.getEmail());
        }
            Teacher teacher = TeacherDtoMapper.map(teacherRegistrationDto);
            Teacher savedTeacher = teacherRepository.save(teacher);
            log.info("New teacher saved with id: {}", savedTeacher.getId());
//            log.debug(savedTeacher.toString());
            return TeacherDtoMapper.map(savedTeacher);
    }



    List<TeacherDto> getAllTeacher() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherDtoMapper::map)
                .toList();
    }

//    List<TeacherNamesDto> getAllTeacherNames() {
//        return teacherRepository.findAll()
//                .stream()
//                .map((t) -> new TeacherNamesDto(t.getFirstName(),t.getLastName()))
//                .map(a -> Arrays.sort(a , new TeacherNamesDto.TeacherNameComparator()))
//                .collect(Collectors.toList());
//    }

    private boolean emailIsAlreadyTaken(TeacherRegistrationDto teacherRegistrationDto) {
        return teacherRepository.existsByEmail(teacherRegistrationDto.getEmail());
    }

}


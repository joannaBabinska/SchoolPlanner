package com.example.schoolplaner.teacher;

import com.example.schoolplaner.teacher.exception.EmailExistException;
import com.example.schoolplaner.teacher.exception.TeacherNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{id}")
    ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id) {
        TeacherDto teacherDto;
        try {
            teacherDto = teacherService.getTeacherById(id);
        } catch (TeacherNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacherDto);

    }

    @PostMapping
    ResponseEntity<?> saveTeacher(@RequestBody TeacherRegistrationDto teacherRegistrationDto) {
        try {
            TeacherDto savedTeacherDto = teacherService.saveTeacher(teacherRegistrationDto);
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedTeacherDto.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(savedTeacherDto);

        } catch (EmailExistException e) {
            return ResponseEntity.badRequest().body("A user with this email address already exists");
        }
    }
}

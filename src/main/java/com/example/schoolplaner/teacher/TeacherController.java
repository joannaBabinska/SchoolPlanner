package com.example.schoolplaner.teacher;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//
//    @PostMapping
//    ResponseEntity<>
}

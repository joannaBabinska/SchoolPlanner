package com.example.schoolplanner.teacher;
import com.example.schoolplanner.teacher.dto.TeacherDto;
import com.example.schoolplanner.teacher.dto.TeacherNamesDto;
import com.example.schoolplanner.teacher.dto.TeacherRegistrationDto;
import com.example.schoolplanner.teacher.exception.EmailExistException;
import com.example.schoolplanner.teacher.exception.TeacherNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{id}")
    ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id) {
        TeacherDto teacherDto = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacherDto);

    }

    @PostMapping
    ResponseEntity<TeacherDto> saveTeacher(@Valid @RequestBody TeacherRegistrationDto teacherRegistrationDto) {
        TeacherDto savedTeacherDto = teacherService.saveTeacher(teacherRegistrationDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTeacherDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedTeacherDto);
    }

    @GetMapping
    ResponseEntity<List<TeacherDto>> getAllTeachers() {
        List<TeacherDto> TeachersDto = teacherService.getAllTeacher();
            return ResponseEntity.ok(TeachersDto);
    }

    @GetMapping("/names")
    ResponseEntity<List<TeacherNamesDto>> getAllTeachersNames() {
        List<TeacherNamesDto> allTeacherNames = teacherService.getAllTeacherNames();
        return ResponseEntity.ok(allTeacherNames);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<TeacherDto> replaceTeacher(@PathVariable Long id,
                                              @RequestBody TeacherRegistrationDto teacherRegistrationDto) {
        TeacherDto teacherDto = teacherService.replaceTeacher(teacherRegistrationDto, id);
        return ResponseEntity.ok(teacherDto);
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody JsonMergePatch jsonMergePatch) throws JsonPatchException, JsonProcessingException {
        teacherService.updateTeacher(id,jsonMergePatch);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(JsonPatchException.class)
    public  ResponseEntity<String> handle(JsonPatchException ex) {
        return ResponseEntity.internalServerError().build();
    }

    @ExceptionHandler(JsonProcessingException.class)
    public  ResponseEntity<String> handle(JsonProcessingException ex) {
        return ResponseEntity.internalServerError().build();
    }

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<String> handle(EmailExistException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<String> handle(TeacherNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Field not valid: " + ex.getMessage());
    }
}

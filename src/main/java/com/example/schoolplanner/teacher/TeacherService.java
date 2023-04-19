package com.example.schoolplanner.teacher;

import com.example.schoolplanner.teacher.dto.*;
import com.example.schoolplanner.teacher.exception.EmailExistException;
import com.example.schoolplanner.teacher.exception.TeacherNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ObjectMapper objectMapper;

    TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
        return TeacherDtoMapper.map(teacher);
    }

    TeacherDto saveTeacher(TeacherRegistrationDto teacherRegistrationDto) {
        if (emailIsAlreadyTaken(teacherRegistrationDto.getEmail())) {
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

    List<TeacherNamesDto> getAllTeacherNames() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherNamesDto::fromEntity)
                .sorted()
                .toList();
    }

    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    public TeacherDto replaceTeacher(TeacherRegistrationDto teacherRegistrationDto, Long id) {
        teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
        if(emailIsAlreadyTaken(teacherRegistrationDto.getEmail())) {
            throw new EmailExistException(teacherRegistrationDto.getEmail());
        }

        Teacher teacherToUpload = TeacherDtoMapper.map(teacherRegistrationDto);
        teacherToUpload.setId(id);
        Teacher savedTeacher = teacherRepository.save(teacherToUpload);
        return TeacherDtoMapper.map(savedTeacher);
    }

    public void updateTeacher(Long id, JsonMergePatch jsonMergePatch) throws JsonPatchException, JsonProcessingException {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
        TeacherUpdateDto teacherUpdateDto = TeacherDtoMapper.mapToTeacherUpdateDto(teacher);
        TeacherUpdateDto updatedTeacher = applyPath(teacherUpdateDto, jsonMergePatch);
        if(!updatedTeacher.getEmail().equals(teacher.getEmail()) && emailIsAlreadyTaken(updatedTeacher.getEmail())){
            throw new EmailExistException(updatedTeacher.getEmail());
        }
        Teacher teacherToSave = TeacherDtoMapper.map(updatedTeacher);
        teacher.setId(id);

        teacherRepository.save(teacherToSave);
    }

    private boolean emailIsAlreadyTaken(String email) {
        return teacherRepository.existsByEmail(email);
    }

    private TeacherUpdateDto applyPath(TeacherUpdateDto teacherUpdateDto, JsonMergePatch jsonMergePatch)
            throws JsonPatchException, JsonProcessingException {
        JsonNode jsonNode = objectMapper.valueToTree(teacherUpdateDto);
        JsonNode teacherPathNode = jsonMergePatch.apply(jsonNode);
        return objectMapper.treeToValue(teacherPathNode, TeacherUpdateDto.class);
    }

}


package com.example.schoolplanner.teacher.dto;
import com.example.schoolplanner.teacher.Teacher;

public class TeacherDtoMapper {
    public static Teacher map(TeacherUpdateDto teacherUpdateDto) {
        return Teacher.builder()
                .firstName(teacherUpdateDto.getFirstName())
                .lastName(teacherUpdateDto.getLastName())
                .email(teacherUpdateDto.getEmail())
                .phoneNumber(teacherUpdateDto.getPhoneNumber())
                .dateOfBirth(teacherUpdateDto.getDateOfBirth())
                .hourlyWage(teacherUpdateDto.getHourlyWage())
                .build();
    }

    public static TeacherUpdateDto mapToTeacherUpdateDto(Teacher teacher) {

        return TeacherUpdateDto.builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .phoneNumber(teacher.getPhoneNumber())
                .dateOfBirth(teacher.getDateOfBirth())
                .hourlyWage(teacher.getHourlyWage())
                .build();
    }

    public static TeacherDto map(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .phoneNumber(teacher.getPhoneNumber())
                .dateOfBirth(teacher.getDateOfBirth())
                .hourlyWage(teacher.getHourlyWage())
                .build();
    }

    public static Teacher map(TeacherRegistrationDto teacherRegistrationDto) {
        return Teacher.builder()
                .firstName(teacherRegistrationDto.getFirstName())
                .lastName(teacherRegistrationDto.getLastName())
                .email(teacherRegistrationDto.getEmail())
                .phoneNumber(teacherRegistrationDto.getPhoneNumber())
                .dateOfBirth(teacherRegistrationDto.getDateOfBirth())
                .hourlyWage(teacherRegistrationDto.getHourlyWage())
                .build();
    }
}

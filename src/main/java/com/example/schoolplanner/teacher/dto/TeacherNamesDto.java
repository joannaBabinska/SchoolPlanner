package com.example.schoolplanner.teacher.dto;

import com.example.schoolplanner.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.function.Function;

@Data
@AllArgsConstructor
public class TeacherNamesDto {
    private String firstName;
    private String lastName;

    public static TeacherNamesDto fromEntity(Teacher teacher) {
        return new TeacherNamesDto(teacher.getFirstName(), teacher.getLastName());
    }

    public static Comparator<TeacherNamesDto> lastNameFirstNameComparator() {
        return Comparator.comparing(TeacherNamesDto::getLastName).thenComparing(TeacherNamesDto::getFirstName);
    }
}


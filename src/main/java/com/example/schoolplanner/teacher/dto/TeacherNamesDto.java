package com.example.schoolplanner.teacher.dto;

import com.example.schoolplanner.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class TeacherNamesDto implements Comparable<TeacherNamesDto> {
    private String firstName;
    private String lastName;


    @Override
    public int compareTo(TeacherNamesDto otherTeacher) {
        return this.lastName.compareTo(otherTeacher.getLastName());
    }

    public static TeacherNamesDto fromEntity(Teacher teacher) {
        return new TeacherNamesDto(teacher.getFirstName(), teacher.getLastName());
    }
}


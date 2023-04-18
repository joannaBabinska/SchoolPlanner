package com.example.schoolplanner.teacher.dto;

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
}


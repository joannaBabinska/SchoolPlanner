package com.example.schoolplaner.teacher;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private BigDecimal hourlyWage;
    private String email;
    private String phoneNumber;

    public TeacherDto(String firstName, String lastName, LocalDate dateOfBirth, BigDecimal hourlyWage, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.hourlyWage = hourlyWage;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public TeacherDto() {
    }
}

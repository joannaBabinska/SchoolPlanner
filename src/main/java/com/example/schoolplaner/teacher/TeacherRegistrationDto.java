package com.example.schoolplaner.teacher;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class TeacherRegistrationDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private BigDecimal hourlyWage;
    private String email;
    private String phoneNumber;
}

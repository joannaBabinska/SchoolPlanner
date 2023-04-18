package com.example.schoolplanner.teacher.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Builder
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private BigDecimal hourlyWage;
    private String email;
    private String phoneNumber;
}

package com.example.schoolplanner.teacher.dto;

import com.example.schoolplanner.teacher.constraint.PhoneNumber;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class TeacherRegistrationDto {
    @NotNull
    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 3, max = 50)
    private String lastName;
    @NotNull
    @Past
    private LocalDate dateOfBirth;
    @Positive
    private BigDecimal hourlyWage;
    @NotNull
    @Email
    private String email;
    @NotNull
    @PhoneNumber
    private String phoneNumber;
}


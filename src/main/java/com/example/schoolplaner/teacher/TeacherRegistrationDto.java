package com.example.schoolplaner.teacher;

import com.example.schoolplaner.teacher.constraint.PhoneNumberConstraint;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class TeacherRegistrationDto {
    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 3, max = 50)
    private String lastName;
    @Past
    private LocalDate dateOfBirth;
    @Positive
    private BigDecimal hourlyWage;
    @Email
    private String email;
    @PhoneNumberConstraint
    private String phoneNumber;
}

package com.example.schoolplanner.teacher.exception;

public class EmailExistException extends RuntimeException {

    public EmailExistException(String email) {
        String message = "Email %s already exist".formatted(email);
    }
}


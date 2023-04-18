package com.example.schoolplanner.teacher.exception;

public class EmailExistException extends RuntimeException {
    public EmailExistException(String email) {
        super("Email %s already exist".formatted(email));

    }
}


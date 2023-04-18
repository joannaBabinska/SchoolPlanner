package com.example.schoolplanner.teacher.exception;

public class EmailExistException extends RuntimeException {
    private final String message;
    public EmailExistException(String email) {
        message = "Email %s already exist".formatted(email);
    }

    @Override
    public String getMessage() {
        return message;
    }
    //todo
}

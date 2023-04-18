package com.example.schoolplanner.teacher.exception;

public class TeacherNotFoundException  extends RuntimeException{
    private final String message;
    public TeacherNotFoundException(Long id) {
        message = "Teacher with %d id not found".formatted(id);
    }

    @Override
    public String getMessage() {
        return message;
    }
}


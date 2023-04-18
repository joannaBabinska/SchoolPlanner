package com.example.schoolplanner.teacher.exception;

public class TeacherNotFoundException  extends RuntimeException{
    public TeacherNotFoundException(Long id) {
        String message = "Teacher with %d id not found".formatted(id);
    }
}


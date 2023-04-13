package com.example.schoolplaner.teacher;

public class TeacherDtoMapper {
    public static Teacher map (TeacherCreateDto teacherCreateDto){
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherCreateDto.getFirstName());
        teacher.setLastName(teacherCreateDto.getLastName());
        teacher.setDateOfBirth(teacherCreateDto.getDateOfBirth());
        teacher.setHourlyWage(teacherCreateDto.getHourlyWage());
        return teacher;
    }
}

package com.example.schoolplaner.teacher;

public class TeacherDtoMapper {
    public static Teacher map(TeacherCreateDto teacherCreateDto) {

        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherCreateDto.getFirstName());
        teacher.setLastName(teacherCreateDto.getLastName());
        teacher.setDateOfBirth(teacherCreateDto.getDateOfBirth());
        teacher.setHourlyWage(teacherCreateDto.getHourlyWage());
        return teacher;
    }

    public static TeacherCreateDto map(Teacher teacher) {

        TeacherCreateDto teacherCreateDto = new TeacherCreateDto();
        teacherCreateDto.setId(teacher.getId());
        teacherCreateDto.setFirstName(teacher.getFirstName());
        teacherCreateDto.setLastName(teacher.getLastName());
        teacherCreateDto.setDateOfBirth(teacher.getDateOfBirth());
        teacherCreateDto.setHourlyWage(teacher.getHourlyWage());
        return teacherCreateDto;
    }

}

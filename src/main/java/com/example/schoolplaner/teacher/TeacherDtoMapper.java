package com.example.schoolplaner.teacher;

public class TeacherDtoMapper {
    public static Teacher map(TeacherDto teacherDto) {

        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPhoneNumber(teacherDto.getPhoneNumber());
        teacher.setDateOfBirth(teacherDto.getDateOfBirth());
        teacher.setHourlyWage(teacherDto.getHourlyWage());
        return teacher;
    }

    public static TeacherDto map(Teacher teacher) {

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setPhoneNumber(teacher.getPhoneNumber());
        teacherDto.setDateOfBirth(teacher.getDateOfBirth());
        teacherDto.setHourlyWage(teacher.getHourlyWage());
        return teacherDto;
    }

    public static Teacher map(TeacherRegistrationDto teacherRegistrationDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRegistrationDto.getFirstName());
        teacher.setLastName(teacherRegistrationDto.getLastName());
        teacher.setEmail(teacherRegistrationDto.getEmail());
        teacher.setPhoneNumber(teacherRegistrationDto.getPhoneNumber());
        teacher.setDateOfBirth(teacherRegistrationDto.getDateOfBirth());
        teacher.setHourlyWage(teacherRegistrationDto.getHourlyWage());
        return teacher;
    }

}

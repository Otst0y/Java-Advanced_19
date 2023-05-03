package lesson_19.utils;

import lesson_19.domain.Student;
import lesson_19.dto.StudentDto;

public class StudentDtoUtil {

    public static Student studentDtoConvert(StudentDto studentDto) {
        StudentDto result = isLegalPassword(studentDto);
        return new Student(result.getFirstName(), result.getLastName(), result.getAge(), result.getEmail(), result.getPassword());
    }

    public static StudentDto isLegalPassword(StudentDto studentDto) {
        if(studentDto.getPassword().equals(studentDto.getCPassword())) {
            return studentDto;
        } else {
            throw new IllegalArgumentException("Passwords don't match.");
        }
    }
}

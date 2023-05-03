package lesson_19.services;

import lesson_19.domain.Student;

public interface StudentService {

    Student save(Student student);
    Student getById(int id);
}

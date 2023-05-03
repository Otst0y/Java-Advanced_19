package lesson_19.services.impl;

import lesson_19.domain.Student;
import lesson_19.repository.StudentRepository;
import lesson_19.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getById(int id) {
        return repository.findById(id).orElse(null);
    }
}

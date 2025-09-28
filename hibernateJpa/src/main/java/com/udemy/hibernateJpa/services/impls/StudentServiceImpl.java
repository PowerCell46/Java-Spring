package com.udemy.hibernateJpa.services.impls;

import com.udemy.hibernateJpa.entities.Student;
import com.udemy.hibernateJpa.exceptions.StudentNotFoundException;
import com.udemy.hibernateJpa.repositories.StudentRepository;
import com.udemy.hibernateJpa.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.SequencedSet;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String getFullName(Student student) {
        return String.format("%s %s", student.getFirstName(), student.getLastName());
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No student found with id: " + id));
    }

    @Override
    public SequencedSet<Student> findAll() {
        return new LinkedHashSet<>(studentRepository.findAll());
    }

    @Override
    public void deleteById(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("No student found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Long deleteAll() {
        long numberOfEntries = studentRepository.count();
        studentRepository.deleteAll();

        return numberOfEntries;
    }

    @Override
    public Student persist(Student student) {
        return studentRepository.save(student);
    }
}

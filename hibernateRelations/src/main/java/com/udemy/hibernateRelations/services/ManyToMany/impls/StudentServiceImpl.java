package com.udemy.hibernateRelations.services.ManyToMany.impls;

import com.udemy.hibernateRelations.entities.ManyToMany.Project;
import com.udemy.hibernateRelations.entities.ManyToMany.Student;
import com.udemy.hibernateRelations.exceptions.notFound.StudentNotFoundException;
import com.udemy.hibernateRelations.repositories.ManyToMany.StudentRepository;
import com.udemy.hibernateRelations.services.ManyToMany.interfaces.ProjectService;
import com.udemy.hibernateRelations.services.ManyToMany.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
public class StudentServiceImpl implements StudentService {

    private static final String NO_STUDENT_FOUND_MSG = "No student found with id: ";

    private final StudentRepository studentRepository;
    private final ProjectService projectService;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ProjectService projectService) {
        this.studentRepository = studentRepository;
        this.projectService = projectService;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new StudentNotFoundException(NO_STUDENT_FOUND_MSG + id));
    }

    @Override
    public Student findByIdWithProjects(Long id) {
        return studentRepository
                .findByIdWithProjects(id)
                .orElseThrow(() -> new StudentNotFoundException(NO_STUDENT_FOUND_MSG + id));
    }

    @Override
    public void addProject(Student student, Project project) {
        // * The relation is declared in Project: let its service handle the relation addition
        projectService.addStudent(project, student);
    }

    @Override
    public void addProjects(Student student, Collection<Project> projects) {
        // * The relation is declared in Project: let its service handle the relation addition
        projects.forEach(project -> projectService.addStudent(project, student));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Student student = findByIdWithProjects(id);

        student.getProjects().forEach(project -> projectService.removeStudent(project, student));
        student.getProjects().clear();

        studentRepository.deleteById(id);
    }
}

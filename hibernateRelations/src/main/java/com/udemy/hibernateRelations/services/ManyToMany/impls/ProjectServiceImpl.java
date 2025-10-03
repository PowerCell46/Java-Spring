package com.udemy.hibernateRelations.services.ManyToMany.impls;

import com.udemy.hibernateRelations.entities.ManyToMany.Project;
import com.udemy.hibernateRelations.entities.ManyToMany.Student;
import com.udemy.hibernateRelations.exceptions.notFound.ProjectNotFoundException;
import com.udemy.hibernateRelations.exceptions.notFound.StudentNotFoundException;
import com.udemy.hibernateRelations.repositories.ManyToMany.ProjectRepository;
import com.udemy.hibernateRelations.services.ManyToMany.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ProjectServiceImpl implements ProjectService {

    private static final String NO_PROJECT_FOUND_MSG = "No project found with id: ";

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository
                .findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(NO_PROJECT_FOUND_MSG + id));
    }

    @Override
    public Project findByIdWithStudents(Long id) {
        return projectRepository
                .findByIdWithStudents(id)
                .orElseThrow(() -> new ProjectNotFoundException(NO_PROJECT_FOUND_MSG + id));
    }

    @Override
    public void addStudent(Project project, Student student) {
        project.getStudents().add(student);
        save(project);
    }

    @Override
    public void addStudents(Project project, Collection<Student> students) {
        project.getStudents().addAll(students);
        save(project);
    }

    @Override
    public void deleteById(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ProjectNotFoundException(NO_PROJECT_FOUND_MSG + id);
        }

        projectRepository.deleteById(id);
    }

    @Override
    public void removeStudent(Project project, Student student) {
        if (!project.getStudents().contains(student)) {
            final String NO_SUCH_STUDENT_IN_PROJECT_MSG = "No such student exists in the project.";
            throw new StudentNotFoundException(NO_SUCH_STUDENT_IN_PROJECT_MSG);
        }

        project.getStudents().remove(student);
    }
}

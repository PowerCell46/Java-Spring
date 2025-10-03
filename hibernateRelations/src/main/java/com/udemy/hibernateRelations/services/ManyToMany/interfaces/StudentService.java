package com.udemy.hibernateRelations.services.ManyToMany.interfaces;

import com.udemy.hibernateRelations.entities.ManyToMany.Project;
import com.udemy.hibernateRelations.entities.ManyToMany.Student;

import java.util.Collection;


public interface StudentService {

    Student save(Student student);

    Student findById(Long id);

    Student findByIdWithProjects(Long id);

    void addProject(Student student, Project project);

    void addProjects(Student student, Collection<Project> projects);

    void deleteById(Long id);
}

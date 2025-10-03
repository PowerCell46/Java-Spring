package com.udemy.hibernateRelations.services.ManyToMany.interfaces;


import com.udemy.hibernateRelations.entities.ManyToMany.Project;
import com.udemy.hibernateRelations.entities.ManyToMany.Student;

import java.util.Collection;


public interface ProjectService {

    Project save(Project project);

    Project findById(Long id);

    Project findByIdWithStudents(Long id);

    void addStudent(Project project, Student student);

    void addStudents(Project project, Collection<Student> students);

    void deleteById(Long id);

    void removeStudent(Project project, Student student);
}

package com.udemy.hibernateRelations.services.OneToMany.interfaces;


import com.udemy.hibernateRelations.entities.OneToMany.Course;
import com.udemy.hibernateRelations.entities.OneToMany.Lecturer;

import java.util.Collection;


public interface LecturerService {

    Lecturer save(Lecturer lecturer);

    Lecturer findById(Long id);

    Lecturer findByIdWithCourses(Long id);

    void addCourse(Lecturer lecturer, Course course);

    void addCourses(Lecturer lecturer, Collection<Course> courses);

    void deleteById(Long id); // Don't del courses, set id = NULL
}

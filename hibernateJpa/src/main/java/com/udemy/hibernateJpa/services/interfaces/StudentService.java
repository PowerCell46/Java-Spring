package com.udemy.hibernateJpa.services.interfaces;


import com.udemy.hibernateJpa.entities.Student;

import java.util.SequencedSet;


public interface StudentService {

    String getFullName(Student student);

    Student persist(Student student);

    Student findById(Integer id);

    SequencedSet<Student> findAll(); // create & update

    void deleteById(Integer id);

    Long deleteAll();
}

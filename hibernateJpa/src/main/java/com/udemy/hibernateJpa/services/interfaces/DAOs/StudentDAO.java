package com.udemy.hibernateJpa.services.interfaces.DAOs;


import com.udemy.hibernateJpa.entities.Student;

import java.util.SequencedSet;


public interface StudentDAO {

    void persist(Student student);

    Student findById(Integer id);

    SequencedSet<Student> findAllByLastNameOrderedByFirstNameAsc(String lastName);

    SequencedSet<Student> findAll();

    Student update(Student updateStudent);

    void deleteById(Integer id);

    Integer deleteAll();
}

package com.udemy.hibernateRelations.services.OneToOne.interfaces;


import com.udemy.hibernateRelations.entities.OneToOne.Instructor;


public interface InstructorService {

    Instructor save(Instructor instructor);

    Instructor findById(Long id);

    void deleteById(Long id);

    void dropInstructorDetailsRelation(Instructor instructor);
}

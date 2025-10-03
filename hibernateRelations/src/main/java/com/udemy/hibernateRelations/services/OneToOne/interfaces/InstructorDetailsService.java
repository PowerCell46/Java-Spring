package com.udemy.hibernateRelations.services.OneToOne.interfaces;


import com.udemy.hibernateRelations.entities.OneToOne.InstructorDetails;


public interface InstructorDetailsService {

    InstructorDetails findById(Long id);

    void deleteById(Long id);
}

package com.udemy.hibernateRelations.services.OneToOne.impls;

import com.udemy.hibernateRelations.entities.OneToOne.Instructor;
import com.udemy.hibernateRelations.entities.OneToOne.InstructorDetails;
import com.udemy.hibernateRelations.exceptions.notFound.InstructorDetailsNotFoundException;
import com.udemy.hibernateRelations.repositories.OneToOne.InstructorDetailsRepository;
import com.udemy.hibernateRelations.services.OneToOne.interfaces.InstructorDetailsService;
import com.udemy.hibernateRelations.services.OneToOne.interfaces.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InstructorDetailsServiceImpl implements InstructorDetailsService {

    private static final String NO_INSTRUCTOR_DETAILS_FOUND_MSG = "No instructor details found with id: ";

    private final InstructorDetailsRepository instructorDetailsRepository;
    private final InstructorService instructorService;

    @Autowired
    public InstructorDetailsServiceImpl(InstructorDetailsRepository instructorDetailsRepository, InstructorService instructorService) {
        this.instructorDetailsRepository = instructorDetailsRepository;
        this.instructorService = instructorService;
    }

    @Override
    public InstructorDetails findById(Long id) {
        return instructorDetailsRepository
                .findById(id)
                .orElseThrow(() -> new InstructorDetailsNotFoundException(NO_INSTRUCTOR_DETAILS_FOUND_MSG + id));
    }

    @Override
    @Transactional // ! All-or-nothing. Either both operations succeed, or both are rolled back.
    public void deleteById(Long id) {
        InstructorDetails instructorDetails = findById(id);
        Instructor instructor = instructorDetails.getInstructor();

        if (instructor != null) {
            instructorService.dropInstructorDetailsRelation(instructor);
        }

        instructorDetailsRepository.deleteById(id);
    }
}

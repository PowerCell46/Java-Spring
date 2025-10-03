package com.udemy.hibernateRelations.services.OneToOne.impls;

import com.udemy.hibernateRelations.entities.OneToOne.Instructor;
import com.udemy.hibernateRelations.exceptions.notFound.InstructorNotFoundException;
import com.udemy.hibernateRelations.repositories.OneToOne.InstructorRepository;
import com.udemy.hibernateRelations.services.OneToOne.interfaces.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InstructorServiceImpl implements InstructorService {

    private static final String NO_INSTRUCTOR_FOUND_MSG = "No instructor found with id: ";

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findById(Long id) {
        return instructorRepository
                .findById(id)
                .orElseThrow(() -> new InstructorNotFoundException(NO_INSTRUCTOR_FOUND_MSG + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!instructorRepository.existsById(id)) {
            throw new InstructorNotFoundException(NO_INSTRUCTOR_FOUND_MSG + id);
        }

        instructorRepository.deleteById(id);
    }

    @Override
    public void dropInstructorDetailsRelation(Instructor instructor) {
        instructor.setInstructorDetails(null);
        instructorRepository.save(instructor);
    }
}

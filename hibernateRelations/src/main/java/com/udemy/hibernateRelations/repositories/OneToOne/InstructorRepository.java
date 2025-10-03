package com.udemy.hibernateRelations.repositories.OneToOne;

import com.udemy.hibernateRelations.entities.OneToOne.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}

package com.udemy.hibernateRelations.repositories.OneToOne;

import com.udemy.hibernateRelations.entities.OneToOne.InstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InstructorDetailsRepository extends JpaRepository<InstructorDetails, Long> {

}

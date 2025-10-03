package com.udemy.hibernateRelations.repositories.OneToMany;

import com.udemy.hibernateRelations.entities.OneToMany.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    // * Eager fetch of the related entity
    @Query("SELECT l FROM Lecturer l LEFT JOIN FETCH l.courses WHERE l.id = :id")
    Optional<Lecturer> findByIdWithCourses(@PathVariable Long id);
}

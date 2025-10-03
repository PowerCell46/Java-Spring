package com.udemy.hibernateRelations.repositories.OneToMany;

import com.udemy.hibernateRelations.entities.OneToMany.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

        // * Eager fetch of the related entity
        @Query("SELECT c FROM Course c LEFT JOIN FETCH c.reviews WHERE c.id = :id")
        Optional<Course> findByIdWithReviews(@PathVariable Long id);
}

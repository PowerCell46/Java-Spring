package com.udemy.hibernateRelations.repositories.ManyToMany;

import com.udemy.hibernateRelations.entities.ManyToMany.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // * Eager fetch of the related entity
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.projects WHERE s.id = :id")
    Optional<Student> findByIdWithProjects(Long id);
}

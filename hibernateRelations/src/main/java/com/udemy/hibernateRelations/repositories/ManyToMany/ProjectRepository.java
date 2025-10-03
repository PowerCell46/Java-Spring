package com.udemy.hibernateRelations.repositories.ManyToMany;

import com.udemy.hibernateRelations.entities.ManyToMany.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // * Eager fetch of the related entity
    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.students WHERE p.id = :id")
    Optional<Project> findByIdWithStudents(Long id);
}

package com.udemy.hibernateJpa.repositories;

import com.udemy.hibernateJpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.SequencedSet;


/**
 * Spring Data JPA Repository Interface
 *
 * This interface extends JpaRepository, which provides CRUD operations automatically.
 * Spring Data JPA creates the implementation at RUNTIME using:
 *
 * 1. Proxy Pattern - Spring creates a proxy object that implements this interface
 * 2. Method Name Conventions - Spring parses method names to generate queries
 * 3. Reflection & Code Generation - Actual implementation is generated dynamically
 *
 * How it works:
 * - Spring scans @Repository interfaces at startup
 * - Creates proxy implementation with all CRUD methods (save, findById, etc.)
 * - Generates SQL queries based on method signatures
 * - Injects this proxy as a bean into the application context
 *
 * You get these methods for FREE:
 * - save(), findById(), findAll(), deleteById(), count(), etc.
 * - Plus any custom methods following naming conventions
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    SequencedSet<Student> findAllByOrderByFirstNameAsc();
}
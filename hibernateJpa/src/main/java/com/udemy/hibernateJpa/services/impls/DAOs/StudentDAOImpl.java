package com.udemy.hibernateJpa.services.impls.DAOs;

import com.udemy.hibernateJpa.entities.Student;
import com.udemy.hibernateJpa.exceptions.StudentNotFoundException;
import com.udemy.hibernateJpa.services.interfaces.DAOs.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.SequencedSet;


/**
 * Data Access Object (DAO) Pattern Implementation
 * <p>
 * DAO provides an abstract interface to the database, encapsulating
 * all access to the data source. The DAO manages the connection to
 * the data source to obtain and store data, separating business logic
 * from data access logic.
 * <p>
 * Benefits:
 * - Separation of concerns (data access vs business logic)
 * - Centralized data access logic
 * - Easy to unit test (can mock data layer)
 * - Database technology can be changed without affecting business code
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @Transactional is required because:
     * - persist() only adds entity to persistence context (in-memory)
     * - Without active transaction, changes are never committed to database
     * - Spring auto-commits transaction when method completes successfully
     */
    @Override
    @Transactional
    public void persist(Student student) {
        entityManager.persist(student);
    }

    /**
     * No need for @Transactional because:
     * - This is a read-only operation that doesn't modify data
     * - find() only retrieves data from database, no commit required
     * - JPA automatically handles read operations without explicit transactions
     */
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override // JPQL
    public SequencedSet<Student> findAllByLastNameOrderedByFirstNameAsc(String lastName) {
        TypedQuery<Student> studentsByLastNameQuery = entityManager
                .createQuery("SELECT s FROM Student s WHERE lastName = :lastName ORDER BY firstName ASC", Student.class);
        studentsByLastNameQuery.setParameter("lastName", lastName);

        return new LinkedHashSet<>(studentsByLastNameQuery.getResultList());
    }

    @Override
    public SequencedSet<Student> findAll() {
        TypedQuery<Student> allStudentQuery = entityManager
                .createQuery("SELECT s FROM Student s ORDER BY id ASC", Student.class);

        return new LinkedHashSet<>(allStudentQuery.getResultList());
    }

    /**
     * @Transactional is required because:
     * - merge() performs write operations that modify the database
     * - Without active transaction, changes stay in persistence context only
     * - Spring auto-commits transaction when method completes successfully
     * <p>
     * merge() method:
     * - Copies state from detached entity to managed entity in persistence context
     * - If entity exists (by ID), updates all fields with new values
     * - If entity doesn't exist, creates new record (less common)
     * - Returns managed entity instance (may be different object than input)
     */
    @Override
    @Transactional
    public Student update(Student updateStudent) {
        return entityManager.merge(updateStudent);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Query deleteByIdQuery = entityManager
                .createQuery("DELETE FROM Student WHERE id = :id");
        deleteByIdQuery.setParameter("id", id);

        int affectedRows = deleteByIdQuery.executeUpdate();

        if (affectedRows == 0)
            throw new StudentNotFoundException("No student found with id: " + id);
    }

    @Override
    @Transactional
    public Integer deleteAll() {
        Query deleteAll = entityManager.createQuery("DELETE FROM Student ");

        return deleteAll.executeUpdate();
    }
}

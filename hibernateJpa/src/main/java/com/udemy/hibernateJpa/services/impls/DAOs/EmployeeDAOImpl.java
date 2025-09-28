package com.udemy.hibernateJpa.services.impls.DAOs;

import com.udemy.hibernateJpa.entities.Employee;
import com.udemy.hibernateJpa.entities.EmployeeRequest;
import com.udemy.hibernateJpa.exceptions.EmployeeNotFoundException;
import com.udemy.hibernateJpa.services.interfaces.DAOs.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.SequencedSet;


@Service
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public SequencedSet<Employee> findAll() {
        TypedQuery<Employee> selectAllEmployees = entityManager
                .createQuery("SELECT e FROM Employee e", Employee.class);

        return new LinkedHashSet<>(selectAllEmployees.getResultList());
    }

    @Override
    public Employee findById(Integer id) {
        TypedQuery<Employee> selectByIdQuery = entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class);
        selectByIdQuery.setParameter("id", id);

        try {
            return selectByIdQuery.getSingleResult();

        } catch (NoResultException e) {
            throw new EmployeeNotFoundException("No employee found with id: " + id);
        }
    }

    @Override
    @Transactional
    public void persist(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    @Transactional
    public Employee persist(EmployeeRequest employeeRequest) {
        Employee employee = employeeRequest.toEmployee();

        entityManager.persist(employee);

        return employee;
    }

    @Override
    @Transactional
    public Employee updateById(EmployeeRequest employeeRequest, Integer id) {
        Employee databaseEmployee = entityManager.find(Employee.class, id);

        if (databaseEmployee == null)
            throw new EmployeeNotFoundException("No employee found with id: " + id);

        Employee incomingEmployee = employeeRequest.toEmployee();

        databaseEmployee.setEmail(incomingEmployee.getEmail());
        databaseEmployee.setFirstName(incomingEmployee.getFirstName());
        databaseEmployee.setLastName(incomingEmployee.getLastName());

        return databaseEmployee;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Query deleteByIdQuery = entityManager
                .createQuery("DELETE FROM Employee e WHERE e.id = :id");
        deleteByIdQuery.setParameter("id", id);

        int rowsAffected = deleteByIdQuery.executeUpdate();

        if (rowsAffected == 0)
            throw new EmployeeNotFoundException("No employee found with id: " + id);
    }
}

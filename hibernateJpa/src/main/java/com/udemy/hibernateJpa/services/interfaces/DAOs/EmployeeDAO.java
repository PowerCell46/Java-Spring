package com.udemy.hibernateJpa.services.interfaces.DAOs;

import com.udemy.hibernateJpa.entities.Employee;
import com.udemy.hibernateJpa.entities.EmployeeRequest;

import java.util.SequencedSet;


public interface EmployeeDAO {

    SequencedSet<Employee> findAll();

    Employee findById(Integer id);

    void persist(Employee employee);

    Employee persist(EmployeeRequest employeeRequest);

    Employee updateById(EmployeeRequest employeeRequest, Integer id);

    void deleteById(Integer id);
}

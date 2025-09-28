package com.udemy.hibernateJpa.services.interfaces;

import com.udemy.hibernateJpa.entities.Employee;
import com.udemy.hibernateJpa.entities.EmployeeRequest;

import java.util.Map;
import java.util.SequencedSet;


public interface EmployeeService {

    SequencedSet<Employee> findAll();

    Employee findById(Integer id);

    void persist(Employee employee);

    Employee persist(EmployeeRequest employeeRequest);

    Employee updateById(EmployeeRequest employeeRequest, Integer id);

    Employee partiallyUpdate(Map<String, Object> upcomingData, Integer id);

    void deleteById(Integer id);
}

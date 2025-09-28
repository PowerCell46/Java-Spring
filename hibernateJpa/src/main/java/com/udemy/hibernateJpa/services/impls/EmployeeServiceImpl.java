package com.udemy.hibernateJpa.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.udemy.hibernateJpa.entities.Employee;
import com.udemy.hibernateJpa.entities.EmployeeRequest;
import com.udemy.hibernateJpa.exceptions.EmployeeNotFoundException;
import com.udemy.hibernateJpa.repositories.EmployeeRepository;
import com.udemy.hibernateJpa.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.SequencedSet;
import java.util.Set;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public SequencedSet<Employee> findAll() {
        return new LinkedHashSet<>(employeeRepository.findAll());
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("No employee found with id: " + id));
    }

    @Override
    public void deleteById(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("No employee found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public void persist(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee persist(EmployeeRequest employeeRequest) {
        Employee employee = employeeRequest.toEmployee(); // cleanup and instantiate

        persist(employee);

        return employee;
    }

    @Override
    public Employee updateById(EmployeeRequest employeeRequest, Integer id) {
        if (!employeeRepository.existsById(id))
            throw new EmployeeNotFoundException("No employee found with id: " + id);

        Employee employee = employeeRequest.toEmployee(); // cleanup and instantiate
        employee.setId(id);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee partiallyUpdate(Map<String, Object> upcomingData, Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("No employee found with id: " + id);
        }

        Employee updatedEmployee = mergePartialUpdates(upcomingData, optionalEmployee.get());

        return employeeRepository.save(updatedEmployee);
    }

    private Employee mergePartialUpdates(Map<String, Object> upcomingData, Employee previousStateEmployee) {
        validateUpdateFields(upcomingData);

        ObjectNode employeeNode = objectMapper.convertValue(previousStateEmployee, ObjectNode.class);
        ObjectNode alterNode = objectMapper.convertValue(upcomingData, ObjectNode.class);

        employeeNode.setAll(alterNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    private void validateUpdateFields(Map<String, Object> updates) {
        Set<String> allowedFields = Set.of("firstName", "lastName", "email");

        for (String field: updates.keySet()) {
            if (!allowedFields.contains(field)) {
                throw new IllegalArgumentException("Field '" + field + "' is not updatable");
            }
        }
    }
}

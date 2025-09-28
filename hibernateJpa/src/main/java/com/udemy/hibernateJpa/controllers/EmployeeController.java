package com.udemy.hibernateJpa.controllers;

import com.udemy.hibernateJpa.entities.Employee;
import com.udemy.hibernateJpa.entities.EmployeeRequest;
import com.udemy.hibernateJpa.services.interfaces.DAOs.EmployeeDAO;
import com.udemy.hibernateJpa.services.interfaces.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.SequencedSet;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeDAO employeeDAO;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeDAO employeeDAO) {
        this.employeeService = employeeService;
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/{id}")
    public Employee getemployee(@PathVariable Integer id) {
        logger.info("POST request on /employees/{}", id);
        return employeeService.findById(id);
    }

    @GetMapping({"/", ""})
    @ResponseBody
    public SequencedSet<Employee> getAllEmployees() {
        logger.info("GET request on /employees");
        return employeeService.findAll();
    }

    @PostMapping({"/", ""})
    public Employee createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        logger.info("POST request on /employees");
        return employeeService.persist(employeeRequest);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @Valid @RequestBody EmployeeRequest employeeRequest,
            @PathVariable Integer id
    ) {
        logger.info("PUT request on /employees/{}", id);
        return employeeService.updateById(employeeRequest, id);
    }

    @PatchMapping("/{id}")
    public Employee partiallyUpdateEmployee(
            @RequestBody Map<String, Object> patchPayload,
            @PathVariable Integer id
    ) {
        return employeeService.partiallyUpdate(patchPayload, id);
    }

    @DeleteMapping("/{id}")
    public Integer deleteByEmployee(@PathVariable Integer id) {
        logger.info("DELETE request on /employees/{}", id);
        employeeService.deleteById(id);
        return id;
    }
}

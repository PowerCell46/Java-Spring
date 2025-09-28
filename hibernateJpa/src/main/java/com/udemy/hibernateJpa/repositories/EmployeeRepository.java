package com.udemy.hibernateJpa.repositories;

import com.udemy.hibernateJpa.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

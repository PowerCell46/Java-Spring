package com.udemy.hibernateJpa.entities;

import com.udemy.hibernateJpa.exceptions.InvalidFieldException;


public class EmployeeRequest {

    private String firstName;

    private String lastName;

    private String email;

    public EmployeeRequest() {}

    public EmployeeRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private static String cleanupStringField(String value, String fieldName) {
        if (value == null || value.strip().isBlank())
            throw new InvalidFieldException(String.format("%s cannot be null or empty.", fieldName));

        value = value.strip();
        if (value.length() > 45)
            throw new InvalidFieldException(String.format("%s has too many characters.", fieldName));

        return value;
    }

    public Employee toEmployee() {
        return new Employee(
          cleanupStringField(firstName, "firstName"),
          cleanupStringField(lastName, "lastName"),
          cleanupStringField(email, "email")
        );
    }
}

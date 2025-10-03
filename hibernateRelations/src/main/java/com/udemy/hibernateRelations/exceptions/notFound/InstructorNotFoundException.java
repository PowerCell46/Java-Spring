package com.udemy.hibernateRelations.exceptions.notFound;


public class InstructorNotFoundException extends RuntimeException {

    public InstructorNotFoundException(String message) {
        super(message);
    }

    public InstructorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
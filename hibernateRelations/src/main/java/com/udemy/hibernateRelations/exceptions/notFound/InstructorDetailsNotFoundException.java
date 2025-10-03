package com.udemy.hibernateRelations.exceptions.notFound;


public class InstructorDetailsNotFoundException extends RuntimeException {

    public InstructorDetailsNotFoundException(String message) {
        super(message);
    }

    public InstructorDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstructorDetailsNotFoundException(Throwable cause) {
        super(cause);
    }
}

package com.udemy.hibernateRelations.exceptions.notFound;


public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Throwable cause) {
        super(cause);
    }

    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourseNotFoundException(String message) {
        super(message);
    }
}

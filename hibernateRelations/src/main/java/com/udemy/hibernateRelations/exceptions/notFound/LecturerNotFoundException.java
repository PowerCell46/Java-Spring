package com.udemy.hibernateRelations.exceptions.notFound;


public class LecturerNotFoundException extends RuntimeException {
    public LecturerNotFoundException(Throwable cause) {
        super(cause);
    }

    public LecturerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LecturerNotFoundException(String message) {
        super(message);
    }
}

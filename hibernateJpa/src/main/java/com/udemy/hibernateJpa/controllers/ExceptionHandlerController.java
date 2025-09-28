package com.udemy.hibernateJpa.controllers;

import com.udemy.hibernateJpa.entities.ErrorResponse;
import com.udemy.hibernateJpa.exceptions.EmployeeNotFoundException;
import com.udemy.hibernateJpa.exceptions.InvalidFieldException;
import com.udemy.hibernateJpa.exceptions.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


/**
 * Global exception handler for all controllers in the application.
 *
 * @ControllerAdvice annotation:
 * - Makes this class a global exception handler across ALL controllers
 * - Spring automatically detects and registers this as exception handling component
 * - Methods with @ExceptionHandler catch exceptions from any @Controller/@RestController
 * - Provides centralized exception handling instead of duplicating in each controller
 * - Executes in order: specific exception types first, then generic Exception handlers
 * - Can be combined with @Order annotation to control handler precedence
 * - Alternative to handling exceptions locally in individual controllers
 *
 * Execution flow:
 * 1. Exception thrown in any controller
 * 2. Spring looks for matching @ExceptionHandler method
 * 3. Most specific match executes (StudentNotFoundException before Exception)
 * 4. Returns ResponseEntity with structured error response
 */
@ControllerAdvice
public class ExceptionHandlerController {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(StudentNotFoundException ex) {
        logger.warn("Handling user not found");

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException ex) {
        logger.warn("Handler employee not found");

        ErrorResponse error = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class) // Argument type/s invalid (passed str instead of int)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException ex) {
        logger.warn("Handling invalid arguments from user");

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid request argument data types.",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFieldException.class)
    public ResponseEntity<ErrorResponse> handleException(InvalidFieldException ex) {
        logger.warn("Handling invalid state of a Data structure");

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException ex) {
        logger.warn("Handling not allowed argument passed by the user");

        ErrorResponse error = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler // Handling all Exceptions (global handler)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        logger.error("Unhandled exception occurred: {}", ex.getMessage(), ex);

        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

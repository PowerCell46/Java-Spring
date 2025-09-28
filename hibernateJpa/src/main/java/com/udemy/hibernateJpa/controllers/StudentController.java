package com.udemy.hibernateJpa.controllers;

import com.udemy.hibernateJpa.entities.Student;
import com.udemy.hibernateJpa.services.interfaces.DAOs.StudentDAO;
import com.udemy.hibernateJpa.services.interfaces.StudentService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.SequencedSet;


@RestController
@RequestMapping(("/students"))
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;
    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentService studentService, StudentDAO studentDAO) {
        this.studentService = studentService;
        this.studentDAO = studentDAO;
    }

    /**
     * Initialization method called after dependency injection is complete.
     *
     * @PostConstruct annotation:
     * - Executed automatically by Spring after all dependencies are injected
     * - Called only ONCE during the bean's lifecycle, after constructor and @Autowired fields
     * - Useful for initialization logic that requires injected dependencies to be available
     * - Runs before the bean is put into service and available to other components
     * - Method must be void, take no parameters, and not throw checked exceptions
     * - Alternative to implementing InitializingBean interface or using init-method in XML
     * <p>
     * Execution order:
     * 1. Constructor called
     * 2. @Autowired dependencies injected
     * 3. @PostConstruct method executed ← This method
     * 4. Bean ready for use
     * <p>
     * Common use cases: database setup, cache initialization, validation, logging
     */
    @PostConstruct
    public void initialize() {
        logger.info("StudentController initialized successfully");
        // Any initialization logic that needs injected dependencies
    }

    /**
     * @ResponseBody annotation:
     * - Tells Spring to convert the return value directly into HTTP response body
     * - Uses message converters (Jackson) to serialize SequencedSet<Student> to JSON
     * - Without @ResponseBody, Spring would look for a view template named "getAllStudents"
     * - Essential for REST APIs that return data instead of HTML pages
     * - Alternative: use @RestController at class level (applies @ResponseBody to all methods)
     */
    @GetMapping({"/", ""})
    @ResponseBody // Not needed, if the controller is REST
    public SequencedSet<Student> getAllStudents() {
        logger.info("GET request on /students/");
        return studentService.findAll();
    }

    /**
     * @PathVariable annotation:
     * - Extracts values from the URL path and binds them to method parameters
     * - Maps the {id} placeholder in @GetMapping("/get/{id}") to the 'id' parameter
     * - Automatically converts URL segment to the parameter type (String to Integer here)
     * - Required by default - if {id} is missing from URL, returns 400 Bad Request
     * - Can specify name explicitly: @PathVariable("id") if parameter name differs
     * <p>
     * URL example: GET /students/get/123 → id parameter receives value 123
     */
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        logger.info("GET request on /students//{}", id);
        return studentService.findById(id);
    }
}

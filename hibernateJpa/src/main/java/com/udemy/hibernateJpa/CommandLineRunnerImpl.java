package com.udemy.hibernateJpa;

import com.udemy.hibernateJpa.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final StudentService studentService;
//    private final StudentDAO studentDAO;

    @Autowired
//    public CommandLineRunnerImpl(StudentService studentService, StudentDAO studentDAO) {
    public CommandLineRunnerImpl(StudentService studentService) {
        this.studentService = studentService;
//        this.studentDAO = studentDAO;
    }

    @Override
    public void run(String... args) {
        System.out.println("Message from CommandLineRunnerImpl...");
    }
}

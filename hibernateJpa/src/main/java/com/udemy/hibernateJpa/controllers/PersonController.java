package com.udemy.hibernateJpa.controllers;

import com.udemy.hibernateJpa.DTOs.PersonDTO;
import com.udemy.hibernateJpa.entities.Person;
import com.udemy.hibernateJpa.services.interfaces.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person createPerson(PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
}

package com.udemy.hibernateJpa.services.interfaces;


import com.udemy.hibernateJpa.DTOs.PersonDTO;
import com.udemy.hibernateJpa.entities.Person;

public interface PersonService {

    Person createPerson(PersonDTO personDTO);
}

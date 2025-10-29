package com.udemy.hibernateJpa.services.impls;

import com.udemy.hibernateJpa.DTOs.PersonDTO;
import com.udemy.hibernateJpa.entities.Person;
import com.udemy.hibernateJpa.proxies.PersonProxy;
import com.udemy.hibernateJpa.repositories.PersonRepository;
import com.udemy.hibernateJpa.services.interfaces.PersonService;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(PersonDTO personDTO) {
        PersonProxy personProxy = new PersonProxy();

        personProxy.setFirstName(personDTO.firstName);
        personProxy.setLastName(personDTO.lastName);
        personProxy.setAge(personDTO.age);
        personProxy.setIsMale(personDTO.isMale);

        return personRepository.save(personProxy.getPerson());
    }
}

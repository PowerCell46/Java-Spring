package com.udemy.hibernateJpa.proxies;


import com.udemy.hibernateJpa.entities.Person;
import com.udemy.hibernateJpa.entityInterfaces.PersonContract;


public class PersonProxy extends BaseProxy implements PersonContract {

    private Person person;

    public PersonProxy() {
        this.person = new Person();
    }

    public PersonProxy(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setFirstName(String firstName) {
        final int MAX_LENGTH = 50;
        final String FIELD_NAME = "First name";

        validateStringField(firstName, MAX_LENGTH, FIELD_NAME);

        firstName = firstName.strip();

        person.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        final int MAX_LENGTH = 50;
        final String FIELD_NAME = "Last name";

        validateStringField(lastName, MAX_LENGTH, FIELD_NAME);

        lastName = lastName.strip();

        person.setLastName(lastName);
    }

    public void setAge(Integer age) {
        final String FIELD_NAME = "Age";
        final int MIN_VALUE = 0;
        final int MAX_VALUE = 150;

        validateIntegerValue(age, MIN_VALUE, MAX_VALUE, FIELD_NAME);

        person.setAge(age);
    }

    public void setIsMale(Boolean isMale) {
        final String FIELD_NAME = "Is male";

        validateBooleanValue(isMale, FIELD_NAME);

        person.setIsMale(isMale);
    }
}

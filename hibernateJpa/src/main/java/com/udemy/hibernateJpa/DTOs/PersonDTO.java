package com.udemy.hibernateJpa.DTOs;


public class PersonDTO {

    public String firstName;

    public String lastName;

    public Integer age;

    public Boolean isMale;

    public PersonDTO() {}

    public PersonDTO(String firstName, String lastName, Integer age, Boolean isMale) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMale = isMale;
    }
}

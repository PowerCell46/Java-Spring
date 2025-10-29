package com.udemy.hibernateJpa.DTOs;

import jakarta.validation.constraints.*;


public class TeacherCreateDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 100)
    private String lastName;

    @NotBlank
    @Email
    @Size(min = 6, max = 100)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10,12}$")
    private String phoneNumber;

    @NotNull
    private Boolean fullTime;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer yearsOfExperience;

    @NotNull
    @Min(0)
    private Double salary;

    @NotNull
    @Min(0)
    @Max(10)
    private Double rating;

    @NotBlank
    @Size(min = 1, max = 100)
    private String department;

    @NotBlank
    @Size(min = 1, max = 100)
    private String subjectSpecialization;

    @NotNull
    private Boolean hasTenure;

    @NotNull
    @Min(18)
    @Max(150)
    private Integer age;

    @NotBlank
    @Size(min = 5, max = 1000)
    private String address;

    @NotNull
    private Boolean active;

    public @NotBlank @Size(min = 3, max = 100) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank @Size(min = 3, max = 100) String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank @Size(min = 3, max = 100) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank @Size(min = 3, max = 100) String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank @Email @Size(min = 6, max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email @Size(min = 6, max = 100) String email) {
        this.email = email;
    }

    public @NotBlank @Pattern(regexp = "^[0-9]{10,12}$") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank @Pattern(regexp = "^[0-9]{10,12}$") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotNull @Min(0) @Max(100) Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(@NotNull @Min(0) @Max(100) Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public @NotNull @Min(0) Double getSalary() {
        return salary;
    }

    public void setSalary(@NotNull @Min(0) Double salary) {
        this.salary = salary;
    }

    public @NotNull @Min(0) @Max(10) Double getRating() {
        return rating;
    }

    public void setRating(@NotNull @Min(0) @Max(10) Double rating) {
        this.rating = rating;
    }

    public @NotBlank @Size(min = 1, max = 100) String getDepartment() {
        return department;
    }

    public void setDepartment(@NotBlank @Size(min = 1, max = 100) String department) {
        this.department = department;
    }

    public @NotBlank @Size(min = 1, max = 100) String getSubjectSpecialization() {
        return subjectSpecialization;
    }

    public void setSubjectSpecialization(@NotBlank @Size(min = 1, max = 100) String subjectSpecialization) {
        this.subjectSpecialization = subjectSpecialization;
    }

    public @NotNull Boolean getHasTenure() {
        return hasTenure;
    }

    public void setHasTenure(@NotNull Boolean hasTenure) {
        this.hasTenure = hasTenure;
    }

    public @NotNull @Min(18) @Max(150) Integer getAge() {
        return age;
    }

    public void setAge(@NotNull @Min(18) @Max(150) Integer age) {
        this.age = age;
    }

    public @NotBlank @Size(min = 5, max = 1000) String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank @Size(min = 5, max = 1000) String address) {
        this.address = address;
    }

    public @NotNull Boolean getFullTime() {
        return fullTime;
    }

    public void setFullTime(@NotNull Boolean fullTime) {
        this.fullTime = fullTime;
    }

    public @NotNull Boolean getActive() {
        return active;
    }

    public void setActive(@NotNull Boolean active) {
        this.active = active;
    }
}

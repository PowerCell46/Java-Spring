package com.udemy.hibernateRelations.services.OneToMany.interfaces;

import com.udemy.hibernateRelations.entities.OneToMany.Course;
import com.udemy.hibernateRelations.entities.OneToMany.Review;

import java.util.Collection;


public interface CourseService {

    Course save(Course course);

    Course findById(Long id);

    Course findByIdWithReviews(Long id);

    void setCoursesLecturerNull(Collection<Course> courses);

    void deleteById(Long id);

    void addReview(Course course, Review review);

    void addReviews(Course course, Collection<Review> reviews);
}

package com.udemy.hibernateRelations.services.OneToMany.interfaces;


import com.udemy.hibernateRelations.entities.OneToMany.Course;
import com.udemy.hibernateRelations.entities.OneToMany.Review;


public interface ReviewService {

    Review save(Review review, Course course);

    void deleteById(Long id);
}

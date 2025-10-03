package com.udemy.hibernateRelations.services.OneToMany.impls;

import com.udemy.hibernateRelations.entities.OneToMany.Course;
import com.udemy.hibernateRelations.entities.OneToMany.Review;
import com.udemy.hibernateRelations.exceptions.notFound.ReviewNotFoundException;
import com.udemy.hibernateRelations.repositories.OneToMany.ReviewRepository;
import com.udemy.hibernateRelations.services.OneToMany.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewServiceImpl implements ReviewService {

    private static final String NO_REVIEW_FOUND_MSG = "No review found with id: ";

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review, Course course) {
        review.setCourse(course);

        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ReviewNotFoundException(NO_REVIEW_FOUND_MSG + id);
        }

        reviewRepository.deleteById(id);
    }
}

package com.udemy.hibernateRelations.services.OneToMany.impls;

import com.udemy.hibernateRelations.entities.OneToMany.Course;
import com.udemy.hibernateRelations.entities.OneToMany.Review;
import com.udemy.hibernateRelations.exceptions.notFound.CourseNotFoundException;
import com.udemy.hibernateRelations.repositories.OneToMany.CourseRepository;
import com.udemy.hibernateRelations.services.OneToMany.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CourseServiceImpl implements CourseService {

    private static final String NO_COURSE_FOUND_MSG = "No course found with id: ";

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository
                .findById(id)
                .orElseThrow(() -> new CourseNotFoundException(NO_COURSE_FOUND_MSG + id));
    }

    @Override
    public Course findByIdWithReviews(Long id) {
        return courseRepository
                .findByIdWithReviews(id)
                .orElseThrow(() -> new CourseNotFoundException(NO_COURSE_FOUND_MSG + id));
    }

    @Override
    public void setCoursesLecturerNull(Collection<Course> courses) {
        courses.forEach(course -> course.setLecturer(null));
    }

    @Override
    public void deleteById(Long id) {
        if (!courseRepository.existsById(id))
            throw new CourseNotFoundException(NO_COURSE_FOUND_MSG + id);

        courseRepository.deleteById(id);
    }

    @Override
    public void addReview(Course course, Review review) {
        course.getReviews().add(review);
        save(course);
    }

    @Override
    public void addReviews(Course course, Collection<Review> reviews) {
        course.getReviews().addAll(reviews);
        save(course);
    }
}

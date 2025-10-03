package com.udemy.hibernateRelations.commandLineRunners;

import com.udemy.hibernateRelations.entities.OneToMany.Course;
import com.udemy.hibernateRelations.entities.OneToMany.Review;
import com.udemy.hibernateRelations.services.OneToMany.interfaces.CourseService;
import com.udemy.hibernateRelations.services.OneToMany.interfaces.LecturerService;
import com.udemy.hibernateRelations.services.OneToMany.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// !@Component
public class OneToManyCommandLineRunnerImpl implements CommandLineRunner {

    private final LecturerService lecturerService;
    private final CourseService courseService;
    private final ReviewService reviewService;

//    ! @Autowired
    public OneToManyCommandLineRunnerImpl(LecturerService lecturerService, CourseService courseService, ReviewService reviewService) {
        this.lecturerService = lecturerService;
        this.courseService = courseService;
        this.reviewService = reviewService;
    }

    @Override
    public void run(String... args) throws Exception {
//        Lecturer lecturer = new Lecturer("Peter", "Gerdzhikov", "PowerCell46");
//
//        Course javaFmiCourse = new Course("Java modern technologies");
//        Course springCourseUdemy = new Course("Spring boot 3, spring 6, hibernate for beginners");
//        Course itCareerElevator = new Course("It career elevator");
        // ! In order to set the relationship on the other size, we have to explicitly set the course.setLecturer
//        lecturerService.addCourses(lecturer, Set.of(javaFmiCourse, springCourseUdemy, itCareerElevator));
//
//        lecturer = lecturerService.save(lecturer);
//        System.out.println(lecturer);

        // * Fetch the lecturer, alongside with its courses
//        Lecturer lecturer = lecturerService.findByIdWithCourses(1L);
//        System.out.println(lecturer);
//        System.out.println(lecturer.getCourses());

//        lecturer.setFirstName("Ivan");
//        lecturer = lecturerService.save(lecturer);
//        System.out.println(lecturer);

        Course course = courseService.findByIdWithReviews(3L);
//        System.out.println(course);

//        course.setTitle("C++ Design patterns");
//        courseService.save(course);

//        lecturerService.deleteById(1L);

//        courseService.deleteById(2l);

        Review review = new Review("Really good, would recommend");
//        courseService.addReview(course, review);
        reviewService.save(review, course);

//        reviewService.deleteById(2l);
    }
}

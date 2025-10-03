package com.udemy.hibernateRelations.services.OneToMany.impls;

import com.udemy.hibernateRelations.entities.OneToMany.Course;
import com.udemy.hibernateRelations.entities.OneToMany.Lecturer;
import com.udemy.hibernateRelations.exceptions.notFound.LecturerNotFoundException;
import com.udemy.hibernateRelations.repositories.OneToMany.LecturerRepository;
import com.udemy.hibernateRelations.services.OneToMany.interfaces.CourseService;
import com.udemy.hibernateRelations.services.OneToMany.interfaces.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
public class LecturerServiceImpl implements LecturerService {

    private static final String NO_LECTURER_FOUND_MSG = "No lecturer found with id: ";

    private final LecturerRepository lecturerRepository;
    private final CourseService courseService;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository, CourseService courseService) {
        this.lecturerRepository = lecturerRepository;
        this.courseService = courseService;
    }

    @Override
    public Lecturer save(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer findById(Long id) {
        return lecturerRepository
                .findById(id)
                .orElseThrow(() -> new LecturerNotFoundException(NO_LECTURER_FOUND_MSG + id));
    }

    @Override
    public Lecturer findByIdWithCourses(Long id) {
        return lecturerRepository
                .findByIdWithCourses(id) // * Custom method for fetching the related courses
                .orElseThrow(() -> new LecturerNotFoundException(NO_LECTURER_FOUND_MSG + id));
    }

    @Override
    public void addCourse(Lecturer lecturer, Course course) {
        lecturer.getCourses().add(course);
        course.setLecturer(lecturer);
    }

    @Override
    public void addCourses(Lecturer lecturer, Collection<Course> courses) {
        lecturer.getCourses().addAll(courses);
        courses.forEach(course -> course.setLecturer(lecturer));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Lecturer lecturer = findByIdWithCourses(id);

        courseService.setCoursesLecturerNull(lecturer.getCourses());
        lecturerRepository.deleteById(id);
    }
}

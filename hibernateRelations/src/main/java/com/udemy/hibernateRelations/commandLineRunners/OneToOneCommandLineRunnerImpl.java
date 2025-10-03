package com.udemy.hibernateRelations.commandLineRunners;

import com.udemy.hibernateRelations.services.OneToOne.interfaces.InstructorDetailsService;
import com.udemy.hibernateRelations.services.OneToOne.interfaces.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// !@Component
public class OneToOneCommandLineRunnerImpl implements CommandLineRunner {

    private final InstructorService instructorService;
    private final InstructorDetailsService instructorDetailsService;

//    !@Autowired
    public OneToOneCommandLineRunnerImpl(InstructorService instructorService, InstructorDetailsService instructorDetailsService) {
        this.instructorService = instructorService;
        this.instructorDetailsService = instructorDetailsService;
    }

    @Override
    public void run(String... args) throws Exception {
//        Instructor instructor = new Instructor("Peter", "Gerdzhikov", "peter.gerdzhikov.contact@gmail.com");
//        InstructorDetails instructorDetails = new InstructorDetails("https://www.youtube/PowerCell46", "Fitness, Programming");
//        instructor.setInstructorDetails(instructorDetails);
         // * CascadeType.PERSIST: Saving instructor will save instructorDetails also
//        instructorService.save(instructor);

        Long instructorId = 3L;
        // * FetchType.EAGER: Fetching the instructor will also fetch the instructorDetails
//        Instructor instructor = instructorService.findById(instructorId);
//        System.out.println("Instructor: " + instructor);
//        System.out.println("Instructor details: " + instructor.getInstructorDetails());

        // * CascadeType.REMOVE: Removing instructor will remove instructorDetails also
//        instructorService.deleteById(instructorId);
//        System.out.println("Deleted instructor with id: " + instructorId);

        Long instructorDetailsId = 4L;
        // * FetchType.EAGER: Fetching the instructorDetails will also fetch the instructor
//        InstructorDetails instructorDetails = instructorDetailsService.findById(instructorDetailsId);
//        Instructor instructor = instructorDetails.getInstructor();
//        System.out.println(instructorDetails);
//        System.out.println(instructor);

        // * No CascadeType.REMOVE, so removing the instructorDetails does not remove the instructor
//        instructorDetailsService.deleteById(instructorDetailsId);
//        System.out.println("Deleted instructorDetails with id: " + instructorDetailsId);
    }
}

package com.udemy.hibernateRelations.commandLineRunners;

import com.udemy.hibernateRelations.entities.ManyToMany.Project;
import com.udemy.hibernateRelations.entities.ManyToMany.Student;
import com.udemy.hibernateRelations.services.ManyToMany.interfaces.ProjectService;
import com.udemy.hibernateRelations.services.ManyToMany.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


// !@Component
public class ManyToManyCommandLineRunnerImpl implements CommandLineRunner {

    private final ProjectService projectService;
    private final StudentService studentService;

//    ! @Autowired
    public ManyToManyCommandLineRunnerImpl(ProjectService projectService, StudentService studentService) {
        this.projectService = projectService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
//        Project project = new Project("Pro Gym gang", "Small as f*ck");
//        project = projectService.save(project);

//        Student me = studentService.findByIdWithProjects(1L);
//        Student stiliyan = new Student("Stiliyan", "Nikolov", "stiliyanNikolov@gmail.com");
//        Student gabiBate = new Student("Gabriel", "Penchev", "gabrielPenchev@abv.bg");
//        projectService.addStudents(project, List.of(me, gabiBate, stiliyan));

//        Student gosho = new Student("Georgi", "Milanov", "g.milanov@yahoo.com");
//        gosho = studentService.save(gosho);

//        Student gosho = studentService.findByIdWithProjects(6L);
//        studentService.addProjects(gosho, List.of(projectService.findByIdWithStudents(2l), projectService.findByIdWithStudents(3l)));

//        projectService.deleteById(3L);
//        studentService.deleteById(2L);
    }
}

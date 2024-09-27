package com.maeda.cruddemo;

import com.maeda.cruddemo.DAO.AppDAO;
import com.maeda.cruddemo.entity.Instructor;
import com.maeda.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            deleteInstructorDetail(appDAO);
        };
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 3;
        appDAO.deleteInstructorDetailByID(id);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2);
        System.out.println("Instructor detail: " + instructorDetail);
        System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting instructor with ID: " + id);
        appDAO.deleteInstructorById(id);
        System.out.println("Done");
    }

    private void findInstructor(AppDAO appDAO) {
        Instructor instructor = appDAO.findInstructorById(2);
        System.out.println("Finding instructor with ID: "+ instructor);
        System.out.println("Instructor: " + instructor);
    }

    private void createInstructor(AppDAO appDAO) {

        Instructor instructor =
                new Instructor("Madhu","Patel", "madhu@luv2code.com");

        InstructorDetail instructorDetail =
                new InstructorDetail("http://www.luv2ode.com/youtube", "guitar");


        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor:" + instructor);

        appDAO.save(instructor);

        System.out.println("Done");
    }
}

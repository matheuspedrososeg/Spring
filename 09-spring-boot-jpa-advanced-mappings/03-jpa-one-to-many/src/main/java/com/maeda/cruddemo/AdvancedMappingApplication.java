package com.maeda.cruddemo;

import com.maeda.cruddemo.DAO.AppDAO;
import com.maeda.cruddemo.entity.Course;
import com.maeda.cruddemo.entity.Instructor;
import com.maeda.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            deleteCourse(appDAO);
        };
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 10;
        appDAO.deleteCourseById(10);
    }

    private void updateCourse(AppDAO appDAO) {
        int courseId = 10;
        Course course = appDAO.findCourseById(courseId);

        course.setTitle("Enjoy the simple things!");
        appDAO.update(course);
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(1);
        instructor.setLastName("TESTER");
        appDAO.update(instructor);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id);
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

        System.out.println("Instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor);
        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        instructor.setCourses(courses);
        System.out.println("Courses: " + instructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("Associated courses: " + instructor.getCourses());

    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor =
                new Instructor("Susan","Public", "susan.public@luv2code.com");

        InstructorDetail instructorDetail =
                new InstructorDetail("http://www.youtube.com", "videogames");

        instructor.setInstructorDetail(instructorDetail);

        Course course = new Course("Air guitar - The ultimate guide.");
        Course course1 = new Course("The pinball masterclass.");

        instructor.add(course);
        instructor.add(course1);

        appDAO.save(instructor);

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

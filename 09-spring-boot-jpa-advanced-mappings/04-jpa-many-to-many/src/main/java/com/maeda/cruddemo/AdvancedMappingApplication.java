package com.maeda.cruddemo;

import com.maeda.cruddemo.DAO.AppDAO;
import com.maeda.cruddemo.entity.*;
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
            deleteStudent(appDAO);
        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int id = 1;
        appDAO.deleteStudentById(1);

        System.out.println("Student deleted.");
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);

        Course course = new Course("Rubik´s cube - How to speed cube");
        Course course1 = new Course("Atari 2600 - Game development");

        student.addCourse(course);
        student.addCourse(course1);
        appDAO.update(student);
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int id = 1;
        Student student = appDAO.findStudentAndCoursesByStudentId(1);

        System.out.println("Student: " + student);
        System.out.println("Courses:" + student.getCourses());
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndStudentsByCourseId(id);

        System.out.println("Course: " + course);
        System.out.println("Students: " + course.getStudents());
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        Course course = new Course("Pacman - How to score one million points.");

        Student student = new Student("John", "Doe", "john@luv2code.com");
        Student student1 = new Student("Mary", "Public", "nary@luv2code.com");

        course.addStudent(student);
        course.addStudent(student1);

        System.out.println(course.getStudents());

        appDAO.save(course);
    }


    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;

        appDAO.deleteCourseById(id);
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);

        System.out.println(course);

        System.out.println(course.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("Pacman - How to score one million points");

        course.addReview(new Review("Great course"));
        course.addReview(new Review("Cool course"));
        course.addReview(new Review("bad"));

        System.out.println(course.getReviews());

        appDAO.save(course);
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
                new Instructor("Susan", "Public", "susan.public@luv2code.com");

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
        System.out.println("Finding instructor with ID: " + instructor);
        System.out.println("Instructor: " + instructor);
    }

    private void createInstructor(AppDAO appDAO) {

        Instructor instructor =
                new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        InstructorDetail instructorDetail =
                new InstructorDetail("http://www.luv2ode.com/youtube", "guitar");


        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor:" + instructor);

        appDAO.save(instructor);

        System.out.println("Done");
    }
}

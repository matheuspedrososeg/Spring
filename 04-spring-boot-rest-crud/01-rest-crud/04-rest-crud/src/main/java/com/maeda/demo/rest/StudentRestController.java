package com.maeda.demo.rest;

import com.maeda.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // @PostConstructor load the student data. only once.
    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //define endpoint for "/students/{studentId} - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //check the studentId against list size
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }

        return theStudents.get(studentId);
    }

}

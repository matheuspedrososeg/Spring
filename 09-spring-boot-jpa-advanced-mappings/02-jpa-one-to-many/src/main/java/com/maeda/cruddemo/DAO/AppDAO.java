package com.maeda.cruddemo.DAO;

import com.maeda.cruddemo.entity.Course;
import com.maeda.cruddemo.entity.Instructor;
import com.maeda.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailByID(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
}

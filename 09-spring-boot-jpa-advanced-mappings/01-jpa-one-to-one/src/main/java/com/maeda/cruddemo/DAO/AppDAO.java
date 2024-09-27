package com.maeda.cruddemo.DAO;

import com.maeda.cruddemo.entity.Instructor;
import com.maeda.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailByID(int id);
}

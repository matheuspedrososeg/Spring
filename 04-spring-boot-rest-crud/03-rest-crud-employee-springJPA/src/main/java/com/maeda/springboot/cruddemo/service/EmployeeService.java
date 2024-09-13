package com.maeda.springboot.cruddemo.service;

import com.maeda.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteByID(int id);
}

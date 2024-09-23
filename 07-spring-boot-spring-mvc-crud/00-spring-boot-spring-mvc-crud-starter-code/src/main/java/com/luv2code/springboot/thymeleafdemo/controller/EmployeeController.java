package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> theEmployees = employeeService.findAll();

        model.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/employee-form.html";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {

        Employee employee = employeeService.findById(theId);
        model.addAttribute("employee", employee);

        return "employees/employee-form.html";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

}

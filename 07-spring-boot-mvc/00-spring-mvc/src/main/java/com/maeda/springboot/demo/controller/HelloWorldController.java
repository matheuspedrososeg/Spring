package com.maeda.springboot.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }


    // controller method to read form data and add data to the model.
    @RequestMapping("/processFormVersionTwo")
    public String shout(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");
        name = name.toUpperCase();

        String result = "Yo! " + name;

        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormV3(@RequestParam("studentName") String name, Model model) {

        name = name.toUpperCase();

        String result = "Hey my friend " + name;

        model.addAttribute("message", result);

        return "helloworld";
    }
}

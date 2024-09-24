package com.maeda.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @RequestMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }
    @RequestMapping("/systems")
    public String showSystems() {
        return "systems";
    }
}

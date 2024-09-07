package com.maeda.springboot.curso.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunRestController {

    // expose "/" that returns hello world.
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "today is your lucky day";
    }

}

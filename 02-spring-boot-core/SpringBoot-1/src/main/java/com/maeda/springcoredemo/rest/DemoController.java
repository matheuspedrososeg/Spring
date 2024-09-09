package com.maeda.springcoredemo.rest;

import com.maeda.springcoredemo.common.Coach;
import com.maeda.springcoredemo.common.CricketCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field
    private Coach myCoach;

    // constructor injection
    @Autowired
    public DemoController(@Qualifier("aquatic")Coach myCoach) {
        this.myCoach = myCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}

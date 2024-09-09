package com.maeda.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("in construcor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1 Km as a warm up.";
    }
}

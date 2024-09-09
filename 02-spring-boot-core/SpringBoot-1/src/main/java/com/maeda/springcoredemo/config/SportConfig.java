package com.maeda.springcoredemo.config;

import com.maeda.springcoredemo.common.Coach;
import com.maeda.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig{
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}

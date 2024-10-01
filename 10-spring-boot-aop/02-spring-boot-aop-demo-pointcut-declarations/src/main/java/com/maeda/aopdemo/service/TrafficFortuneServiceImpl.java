package com.maeda.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements  TrafficFortuneService {
    @Override
    public String getFortune() {

        try {
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic this morning.";
    }

    @Override
    public String getFortune(boolean tripwire) {
        if (tripwire) {
            throw new RuntimeException("Major accident! highway closed");
        }
        return getFortune();
    }
}

package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

/**
 * SwimCoach
 */
public class SwimCoach implements Coach {

    @Value("${team}")
    public String team;

    @Value("${email}")
    public String email;

    private FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim a mile!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    
}
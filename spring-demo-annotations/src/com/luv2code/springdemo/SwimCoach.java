package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

/**
 * SwimCoach
 */
public class SwimCoach implements Coach {

    @Value("${team}")
    private String team;

    @Value("${email}")
    private String email;

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

    public String getEmail() {
        return email;
    }
    
    public String getTeam() {
        return team;
    }
}
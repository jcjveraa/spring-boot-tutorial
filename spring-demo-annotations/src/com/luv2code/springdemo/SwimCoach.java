package com.luv2code.springdemo;

/**
 * SwimCoach
 */
public class SwimCoach implements Coach {

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
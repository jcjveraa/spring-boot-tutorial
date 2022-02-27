package com.luv2code.springdemo;

public class PracticeCoach implements Coach {
    private FortuneService fortuneService;

    public PracticeCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Just practice a little...";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}

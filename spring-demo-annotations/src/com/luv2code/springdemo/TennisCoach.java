package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;

    // @Autowired
    // public TennisCoach(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    // public TennisCoach() {
    //     System.out.println(">> inside default ctor");
    // }

    @Override
    public String getDailyWorkout() {
        return "Go hit some balls";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // @Autowired
    // public void setFortuneService(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    // Spring will always run Autowired methods, apparently - doesn't need to be a 'setXXX' one
    // @Autowired
    // public void randomMethod(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

}

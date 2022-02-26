package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Value("${team}")
    private String team;
    @Value("${email}")
    private String email;

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    // @Autowired
    // public TennisCoach(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    // Don't even need the default ctor

    public TennisCoach() {
        System.out.println(">> inside default ctor");
        System.out.println(team); //@Value is after ctor it seems
    }

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

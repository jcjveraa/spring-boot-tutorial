package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracticeConfig.class);

        Coach coach = context.getBean("practiceCoach", Coach.class);

        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());

        context.close();
    }
}

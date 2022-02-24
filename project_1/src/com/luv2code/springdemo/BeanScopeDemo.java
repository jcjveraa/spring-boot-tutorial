package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        if (coach == alphaCoach) {
            System.out.println("Yup, these are the same object for sure!");
        } else {
            System.err.println("Nope, not the same object...");;
        }

        System.out.println("\nMemory location coach\t\t\t" + coach);
        System.out.println("Memory location alphaCoach\t\t" + alphaCoach + "\n");

        context.close();
    }
}

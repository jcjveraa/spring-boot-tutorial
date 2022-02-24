package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

    String[] fortunes = {"Random fortune 1!", "Random fortune 2!", "Here be Dragons!"};

    @Override
    public String getFortune() {
        Random random = new Random();
        int randomIndex = random.nextInt(fortunes.length);
        return fortunes[randomIndex];
    }
    
}

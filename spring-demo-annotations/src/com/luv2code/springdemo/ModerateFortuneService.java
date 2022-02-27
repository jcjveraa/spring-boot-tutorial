package com.luv2code.springdemo;

public class ModerateFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Today will be an average day ¯\\_(ツ)_/¯";
    }
    
}

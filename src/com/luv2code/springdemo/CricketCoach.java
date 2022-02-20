package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	public CricketCoach() {
		// TODO Auto-generated constructor stub
	}

	// Setter injection
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Wicked Wickets dude!";
	}

	@Override
	public String getDailyFortune() {
		return "Crickets chirping... " + fortuneService.getFortune();
	}

	@Override
	public String getOnlineFortune() {
		return "Crickets chirping... " + fortuneService.getOnlineForturne();
	}

}

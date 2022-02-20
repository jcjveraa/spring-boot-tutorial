package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is great for Coding!";
    }

	@Override
	public String getOnlineForturne() {
		try {
			URL fortuneApiUrl = new URL("https://fortuneapi.herokuapp.com/");
		     BufferedReader in = new BufferedReader(
		    	        new InputStreamReader(fortuneApiUrl.openStream()));
		     String result = in.readLine();
		     in.close();
		     
		     return result;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Getting online quote failed...";
	}
    
    

}

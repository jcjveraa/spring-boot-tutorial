package com.luv2code.springdemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

    private Fortune[] fortunes;

    @Override
    public String getFortune() {
        Random random = new Random();
        int randomIndex = random.nextInt(fortunes.length);
        return fortunes[randomIndex].fortune;
    }

    public FileFortuneService(@Value("${fortunesFile}") String fortunesFile) {

        try {
            File resource = new ClassPathResource(fortunesFile).getFile();
            String json = new String(Files.readAllBytes(resource.toPath()));

            Gson gson = new Gson();
            JsonObject jsonRoot = gson.fromJson(json, JsonObject.class);
            JsonElement fortunesArray = jsonRoot.get("fortunes");

            fortunes = gson.fromJson(fortunesArray, Fortune[].class);
            
        } catch (IOException e) {
                       e.printStackTrace();
        }
    }
    
}

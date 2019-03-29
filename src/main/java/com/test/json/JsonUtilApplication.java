package com.test.json;

import com.test.json.util.JSONArrayUtil;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonUtilApplication implements ApplicationRunner {

    @Autowired
    JSONArrayUtil jsonArrayUtil;

    private static final Logger log = LoggerFactory.getLogger(JsonUtilApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(JsonUtilApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] stringArray = {"Eight", "SeveN", "zeRo", "foUR"};
        JSONArray jsonStringArray = new JSONArray(stringArray);
        log.info("Given JSON String array is : " + jsonStringArray.toString());
        JSONArray sortedJsonArray = jsonArrayUtil.sort(jsonStringArray);
        log.info("Sorted JSON String array is : " + sortedJsonArray.toString());

    }
}

package com.test.json.util.impl;

import com.test.json.util.JSONArrayUtil;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component(value = "jsonArrayUtil")
public class JSONArrayUtilImpl implements JSONArrayUtil {

    Map<Integer, String> numbersMap = new TreeMap<>();


    private void loadNumbersMap() {
        numbersMap.put(0, "zero");
        numbersMap.put(1, "one");
        numbersMap.put(2, "two");
        numbersMap.put(3, "three");
        numbersMap.put(4, "four");
        numbersMap.put(5, "five");
        numbersMap.put(6, "six");
        numbersMap.put(7, "seven");
        numbersMap.put(8, "eight");
        numbersMap.put(9, "nine");
    }


    @Override
    public JSONArray sort(JSONArray jsonArray) {

        loadNumbersMap();

        if (jsonArray == null || jsonArray.length() == 0) {
            throw new IllegalArgumentException("JSON Array -  \"" + jsonArray.toString() + "\" should have at least one JSON object");
        }

        List<String> jsonVals = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            jsonVals.add(jsonArray.getString(i));
        }

        List<String> sortedStringList = jsonVals
                .stream()
                .filter(s -> numbersMap.containsValue(s.toLowerCase()))
                .map(s -> numbersMap.entrySet()
                        .stream()
                        .filter(e -> e.getValue().equalsIgnoreCase(s.toLowerCase()))
                        .map(e -> e.getKey())
                        .findAny().get())
                .sorted()
                .map(i -> numbersMap.get(i))
                .map(s -> jsonVals.stream().filter(j -> j.equalsIgnoreCase(s)).findAny().get())
                .collect(Collectors.toList());

        return new JSONArray(sortedStringList);

    }
}

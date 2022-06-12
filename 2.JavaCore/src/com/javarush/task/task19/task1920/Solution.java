package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        String str;
        while ((str = fileReader.readLine()) != null) {
            String[] nameAndValue;
            nameAndValue = str.split(" ");
            if (map.containsKey(nameAndValue[0])) {
                map.put(nameAndValue[0], map.get(nameAndValue[0]) + Double.parseDouble(nameAndValue[1]));
            }
            else {
                map.put(nameAndValue[0], Double.parseDouble(nameAndValue[1]));
            }
        }
        fileReader.close();
        double maxValue = 0;
        for (Map.Entry<String, Double> entry:map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }
        for (Map.Entry<String, Double> entry:map.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println(entry.getKey());
            }
        }
    }
}

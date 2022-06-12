package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
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
        for (Map.Entry<String, Double> entry:map.entrySet()) {
            System.out.println(String.format("%s %s", entry.getKey(), String.valueOf(entry.getValue())));
        }

    }
}

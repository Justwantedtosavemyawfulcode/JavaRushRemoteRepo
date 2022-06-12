package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String url = bufferedReader.readLine();
        String[] afterAskMark = url.split("\\?");
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(afterAskMark[1].split("&")));
        ArrayList<String> finalList = new ArrayList<>();
        for (String s:list) {
            if (s.contains("=")) {
                String[] keyAndValue = s.split("=");
                if (keyAndValue[0].equals("obj")) {
                    finalList.add(keyAndValue[0]);
                    finalList.add(keyAndValue[1]);
                    continue;
                }
                finalList.add(keyAndValue[0]);
            }
            else {
                finalList.add(s);

            }
        }
        String valueOfObj = "";
        for (int i = 0; i < finalList.size(); i++) {
            if (finalList.get(i).equals("obj")) {
                valueOfObj = finalList.get(i + 1);
                finalList.set(i + 1, "");
            }
        }

        if (finalList.contains("")) {
            finalList.remove("");
        }

        for (String s:finalList) {
            System.out.print(s + " ");
        }
        System.out.println();
        if (finalList.contains("obj")) {
            try {
                alert(Double.parseDouble(valueOfObj));
            } catch (NumberFormatException e) {
                alert(valueOfObj);
            }
        }
    }

        //add your code here

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

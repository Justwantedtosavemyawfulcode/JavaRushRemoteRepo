package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String month = bufferedReader.readLine();
        Map<String, Integer> arrayOfMonth = new HashMap<>();
        arrayOfMonth.put("January", 1);
        arrayOfMonth.put("February", 2);
        arrayOfMonth.put("March", 3);
        arrayOfMonth.put("April", 4);
        arrayOfMonth.put("May", 5);
        arrayOfMonth.put("June", 6);
        arrayOfMonth.put("July", 7);
        arrayOfMonth.put("August", 8);
        arrayOfMonth.put("September", 9);
        arrayOfMonth.put("October", 10);
        arrayOfMonth.put("November", 11);
        arrayOfMonth.put("December", 12);
        for (Map.Entry<String, Integer> pair: arrayOfMonth.entrySet()) {
            if (pair.getKey().equals(month)) {
                System.out.println(month + " is the " + pair.getValue() + " month");
            }
        }
        //напишите тут ваш код
    }
}

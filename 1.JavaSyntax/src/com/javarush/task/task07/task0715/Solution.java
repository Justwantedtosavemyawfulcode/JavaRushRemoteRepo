package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
        lst.add("мама");
        lst.add("мыла");
        lst.add("раму");
        int counter = 1;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            lst.add(counter, "именно");
            counter +=2;
        }
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
        //напишите тут ваш код
    }
}

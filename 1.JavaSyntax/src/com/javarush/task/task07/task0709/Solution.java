package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<String> lst = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int min;
        for (int i = 0; i < 5; i++) {
            String c = bufferedReader.readLine();
            strings.add(c);
        }
        min = strings.get(0).length();
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() <= min) {
                lst.add(strings.get(i));
                min = strings.get(i).length();
            }
        }
        ArrayList<String> stringsNew = new ArrayList<String>();
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).length() == min) {
                System.out.println((lst.get(i)));
            }
        }
        //напишите тут ваш код
    }
}

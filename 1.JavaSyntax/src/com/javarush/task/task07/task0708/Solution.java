package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> lst = new ArrayList<String>();
        int lenCounter = 0;
        for (int i = 0; i < 5; i++) {
            String str = bufferedReader.readLine();
            strings.add(str);
        }
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() >= lenCounter) {
                lst.add(strings.get(i));
                lenCounter = strings.get(i).length();
            }
        }
        strings = new ArrayList<String >();
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).length() == lenCounter) {
                strings.add(lst.get(i));
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
        //напишите тут ваш код
    }
}

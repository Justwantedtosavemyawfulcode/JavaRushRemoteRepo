package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] lst = new String[10];
        for (int i = 0; i < 8; i++) {
            String str = bufferedReader.readLine();
            lst[i] = str;
        }
        for (int i = lst.length - 1; i >= 0; i--) {
            System.out.println(lst[i]);
        }
        //напишите тут ваш код
    }
}
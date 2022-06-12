package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strList = new String[10];
        int[] intList = new int[10];
        for (int i = 0; i < strList.length; i++) {
            String s = bufferedReader.readLine();
            strList[i] = s;
        }
        for (int i = 0; i < strList.length; i++) {
            intList[i] = strList[i].length();
        }
        for (int i = 0; i < intList.length; i++) {
            System.out.println(intList[i]);
        }
        //напишите тут ваш код
    }
}

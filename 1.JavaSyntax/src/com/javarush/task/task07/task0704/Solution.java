package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] lst = new int[10];
        for (int i = 0; i < lst.length; i++) {
            int digit = Integer.parseInt(bufferedReader.readLine());
            lst[i] = digit;
        }
        for (int i = lst.length - 1; i >= 0; i--) {
            System.out.println(lst[i]);
        }
        //напишите тут ваш код
    }
}


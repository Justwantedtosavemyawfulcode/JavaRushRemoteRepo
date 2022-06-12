package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;
        int[] lst = new int[20];
        for (int i = 0; i < lst.length; i++) {
            int s = Integer.parseInt(reader.readLine());
            lst[i] = s;
        }
        minimum = lst[0];
        maximum = lst[0];
        for (int value : lst) {
            if (value < minimum) {
                minimum = value;
            }
            if (value > maximum) {
                maximum = value;
            }
        }
        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}

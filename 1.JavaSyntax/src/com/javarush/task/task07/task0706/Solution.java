package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] listOfHomes = new int[15];
        int chetnoe = 0;
        int nechetnoe = 0;
        for (int i = 0; i < listOfHomes.length; i++) {
            int digit = Integer.parseInt(bufferedReader.readLine());
            listOfHomes[i] = digit;
            if (i % 2 == 0 || i == 0) {
                chetnoe += digit;
            }
            else {
                nechetnoe += digit;
            }
        }
        if (chetnoe < nechetnoe) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
        else {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        //напишите тут ваш код
    }
}

package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        String numba = Integer.toString(num);

        if (num >= 1 && num <= 999) {
            if (numba.length() == 1 && num % 2 == 0) {
                System.out.println("четное однозначное число");
            }
            if (numba.length() == 2 && num % 2 == 0) {
                System.out.println("четное двузначное число");
            }
            if (numba.length() == 3 && num % 2 == 0) {
                System.out.println("четное трехзначное число");
            }
            if (numba.length() == 1 && num % 2 != 0) {
                System.out.println("нечетное однозначное число");
            }
            if (numba.length() == 3 && num % 2 != 0) {
                System.out.println("нечетное трехзначное число");
            }
            if (numba.length() == 2 && num % 2 != 0) {
                System.out.println("нечетное двузначное число");
            }
        }
        //напишите тут ваш код

    }
}

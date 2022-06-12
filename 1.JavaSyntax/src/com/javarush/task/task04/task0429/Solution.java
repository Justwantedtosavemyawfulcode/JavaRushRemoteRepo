package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());
        int num3 = Integer.parseInt(bufferedReader.readLine());
        int counter = 0;
        int minusCounter = 0;

        if (num > 0) {
            counter += 1;
        }
        if (num < 0)
            minusCounter += 1;
        if (num2 > 0) {
            counter += 1;
        }
        if (num2 < 0)
            minusCounter += 1;
        if (num3 > 0) {
            counter += 1;
        }
        if (num3 < 0)
            minusCounter += 1;
        System.out.println("количество положительных чисел: " + counter);
        System.out.println("количество отрицательных чисел: " + minusCounter);
        //напишите тут ваш код

    }
}

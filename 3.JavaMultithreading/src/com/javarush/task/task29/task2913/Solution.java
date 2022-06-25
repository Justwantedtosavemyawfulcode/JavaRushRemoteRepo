package com.javarush.task.task29.task2913;

import java.util.ArrayList;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        ArrayList<Integer> listOfAllNumbers = new ArrayList<>();
        if (a > b) {
            for (int i = a; i >= b; i--) {
                listOfAllNumbers.add(i);
            }
        }

        if (a < b) {
            for (int i = a; i <= b; i++) {
                listOfAllNumbers.add(i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : listOfAllNumbers) {
            stringBuilder.append(i + " ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}
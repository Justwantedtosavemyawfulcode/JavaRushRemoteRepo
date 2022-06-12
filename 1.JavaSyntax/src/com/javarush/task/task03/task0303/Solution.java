package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(50, 1.12));
        System.out.println(convertEurToUsd(88, 1.12));
        //напишите тут ваш код

    }

    public static double convertEurToUsd(int eur, double course) {
        return eur * course;
        //напишите тут ваш код

    }
}

package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    public static int convertToSeconds(int hour) {
        return (hour * 60) * 60;
    }
    //напишите тут ваш код

    public static void main(String[] args) {
        System.out.println(convertToSeconds(4));
        System.out.println(convertToSeconds(1));

        //напишите тут ваш код

    }
}

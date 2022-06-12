package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getSecondsAfter15(30));
    }

    public static int getSecondsAfter15(int time) {
        return time * 60;
    }
}
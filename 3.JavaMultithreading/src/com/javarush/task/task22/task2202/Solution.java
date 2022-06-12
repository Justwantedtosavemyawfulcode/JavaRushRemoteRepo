package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        char[] charString = string.toCharArray();
        int counter = 0;
        for (char c:charString) {
            if (counter == 4) {
                break;
            }
            if (c == ' ') {
                counter++;
            }
        }
        if (counter < 4) {
            throw new TooShortStringException();
        }
        String[] stringTabs = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            stringBuilder.append(stringTabs[i] + " ");
        }
        return stringBuilder.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

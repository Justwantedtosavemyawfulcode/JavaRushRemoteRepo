package com.javarush.task.task30.task3002;

/*
Осваиваем методы класса Integer
*/

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.contains("x")) {
            return String.valueOf(Integer.parseInt(s.substring(s.indexOf("x") + 1), 16));
        }
        else if (s.contains("b")) {
            return String.valueOf(Integer.parseInt(s.substring(s.indexOf("b") + 1), 2));
        }
        else if (s.startsWith("0")) {
            return String.valueOf(Integer.parseInt(s, 8));
        }
        else {
            return String.valueOf(Integer.parseInt(s, 10));
        }


        //напишите тут ваш код
    }
}
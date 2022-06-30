package com.javarush.task.task30.task3010;

import java.math.BigInteger;/*
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        int minRadix = 0;
        for (int i = 2; i <= 36; i++) {
            try {
                BigInteger bigInteger = new BigInteger(args[0], i);
                minRadix = i;
                break;
            }
            catch (Exception e) {

            }
        }
        if (minRadix != 0) {
            System.out.println(minRadix);
        }
        else System.out.println("incorrect");
        //напишите тут ваш код
    }
}
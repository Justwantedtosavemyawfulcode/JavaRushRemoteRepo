package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        try {
            BigInteger bigIntegerForCheckingOfException = new BigInteger(number);
        }
        catch (NumberFormatException e) {
            return new HashSet<>();
        }


        Set<Integer> returningSet = new HashSet<>();
        for (int i = 2; i <= 36; i++) {
            BigInteger bigInteger = new BigInteger(number);
            String numberInGivenRadix = bigInteger.toString(i);
            StringBuilder stringBuilder = new StringBuilder(numberInGivenRadix);
            if (numberInGivenRadix.equals(stringBuilder.reverse().toString())) {
                returningSet.add(i);
            }
//            for (int j = 0; j < numberInGivenRadix.length(); j++) {
//                if (!(numberInGivenRadix.charAt(j) == numberInGivenRadix.charAt(numberInGivenRadix.length() - 1 - j))) {
//                    break;
//                }
//                else if (j == numberInGivenRadix.length() - 1) {
//                    returningSet.add(i);
//                }
        }
        return returningSet;
    }
}
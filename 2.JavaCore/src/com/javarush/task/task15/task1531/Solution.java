package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int i) {
        if (i < 0) {
            return Integer.toString(0);
        }
        BigInteger sum = BigInteger.valueOf(1);
        for (int j = 1; j <= i; j++) {
            BigInteger secondJ = BigInteger.valueOf(j);
            sum = sum.multiply(secondJ);

        }
        return String.valueOf(sum);
    }


}

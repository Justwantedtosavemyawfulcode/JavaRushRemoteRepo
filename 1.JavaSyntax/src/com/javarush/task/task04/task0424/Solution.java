package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());
        int num3 = Integer.parseInt(bufferedReader.readLine());

        if (num1 != num2 && num2 == num3) {
            System.out.println("1");
        }
        if (num2 != num1 && num1 == num3) {
            System.out.println("2");
        }
        if (num3 != num1 && num1 == num2) {
            System.out.println("3");
        }
        //напишите тут ваш код

    }
}

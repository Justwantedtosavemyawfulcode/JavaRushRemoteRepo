package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        if (num > 0 && num % 2 ==0) {
            System.out.println("положительное четное число");
        }
        if (num < 0 && num % 2 ==0) {
            System.out.println("отрицательное четное число");
        }
        if (num > 0 && num % 2 !=0) {
            System.out.println("положительное нечетное число");
        }
        if (num < 0 && num % 2 !=0) {
            System.out.println("отрицательное нечетное число");
        }
        if (num == 0) {
            System.out.println("ноль");
        }
        //напишите тут ваш код

    }
}

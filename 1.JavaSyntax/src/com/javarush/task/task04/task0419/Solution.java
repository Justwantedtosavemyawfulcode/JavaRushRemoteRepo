package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        int d = Integer.parseInt(bufferedReader.readLine());

        System.out.println(compare(a, b, c, d));

        //напишите тут ваш код

    }

    public static int compare (int a, int b, int c, int d){
        int cacheNum1;
        int cacheNum2;

        if (a > b)
            cacheNum1 = a;
        else
            cacheNum1 = b;
        if (c > d)
            cacheNum2 = c;
        else
            cacheNum2 = d;
        if (cacheNum1 > cacheNum2)
            return cacheNum1;
        else
            return cacheNum2;


    }
}

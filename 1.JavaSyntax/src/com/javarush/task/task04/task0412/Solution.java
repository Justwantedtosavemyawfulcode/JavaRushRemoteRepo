package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        if (num == 0)
            System.out.println(0);
        if (num > 0)
            System.out.println(num * 2);
        if (num < 0)
            System.out.println(num + 1);
        //напишите тут ваш код

    }

}
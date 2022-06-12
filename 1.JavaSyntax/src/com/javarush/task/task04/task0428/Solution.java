package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());
        int num3 = Integer.parseInt(bufferedReader.readLine());
        int counter = 0;

        if (num > 0) {
            counter += 1;
        }
        if (num2 > 0) {
            counter += 1;
        }
        if (num3 > 0) {
            counter += 1;
        }
        System.out.println(counter);
        //напишите тут ваш код

    }
}

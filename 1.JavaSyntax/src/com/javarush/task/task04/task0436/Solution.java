package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(8);

            }
            System.out.println();

        }
        //напишите тут ваш код

    }
}

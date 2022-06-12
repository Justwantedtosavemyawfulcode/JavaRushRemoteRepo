package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cacheTime = bufferedReader.readLine();
        double time = Double.parseDouble(cacheTime);

        if (time % 5 >= 4 && time % 5 < 5)
            System.out.println("красный");
        else if (time % 5 >= 3 && time % 5 < 4)
            System.out.println("жёлтый");
        else
            System.out.println("зелёный");
    }
}
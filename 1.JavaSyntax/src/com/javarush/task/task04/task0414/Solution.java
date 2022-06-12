package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bufferedReader.readLine());
        String cache;

        if (year % 400 == 0)
            cache = "количество дней в году: 366";

        else if (year % 100 == 0)
            cache = "количество дней в году: 365";

        else if (year % 4 == 0)
            cache = "количество дней в году: 366";

        else
            cache = "количество дней в году: 365";

        System.out.println(cache);
        //напишите тут ваш код

    }
}
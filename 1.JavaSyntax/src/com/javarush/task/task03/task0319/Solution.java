package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        String cacheZp = bufferedReader.readLine();
        int zp = Integer.parseInt(cacheZp);
        String cacheYears = bufferedReader.readLine();
        int years = Integer.parseInt(cacheYears);

        System.out.println(name + " получает " + zp + " через " + years + " лет.");
        //напишите тут ваш код

    }
}

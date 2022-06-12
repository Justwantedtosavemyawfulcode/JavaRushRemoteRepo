package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int cacheNumMin;
        int cacheNumMax;
        int cacheNumAvg;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        cacheNumMin = a;
        int b = Integer.parseInt(bufferedReader.readLine());
        if (a < b)
            cacheNumMax = b;
        else {
            cacheNumMax = a;
            cacheNumMin = b;
        }
        int c = Integer.parseInt(bufferedReader.readLine());
        if (cacheNumMax < c) {
            cacheNumMax = c;
            if (a < b)
                cacheNumAvg = b;
            else
                cacheNumAvg = a;
        }
        else
        if (c > cacheNumMin)
            cacheNumAvg = c;
        else {
            cacheNumAvg = cacheNumMin;
            cacheNumMin = c;
        }

        System.out.println(cacheNumAvg);

        //напишите тут ваш код

    }
}

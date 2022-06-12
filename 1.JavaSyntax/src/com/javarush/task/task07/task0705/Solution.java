package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] bigList = new int[20];
        int[] firstSmallList = new int[10];
        int[] secondSmallList = new int[10];
        for (int i = 0; i < bigList.length; i++) {
            int digit = Integer.parseInt(bufferedReader.readLine());
            bigList[i] = digit;
        }
        for (int i = 0; i < firstSmallList.length; i++) {
            firstSmallList[i] = bigList[i];
            secondSmallList[i] = bigList[i + 10];
            System.out.println(secondSmallList[i]);
            }
        }
}
        //напишите тут ваш код


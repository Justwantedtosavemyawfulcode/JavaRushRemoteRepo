package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[20];
        for (int i = 0; i < list.length; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            list[i] = num;
        }
        return list;
    }

    public static int max(int[] array) {
        int maxNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber && maxNumber != 0) {
                maxNumber = array[i];
            }
            if (maxNumber == 0) {
                maxNumber += array[i];
            }
        }
        return maxNumber;
    }
}


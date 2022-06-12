package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        ArrayList<Long> nums = new ArrayList();
        for (long i = 0; i < N; i++) {
            char[] arrNumbers = String.valueOf(i).toCharArray();
            int m = arrNumbers.length;
            long sum = 0;
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(String.valueOf(arrNumbers[j]));
                sum += Math.pow(x, m);
            }
            if (sum == i) {
                nums.add(i);
            }
        }
        long[] result = new long[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            result[i] = nums.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100065465L)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}

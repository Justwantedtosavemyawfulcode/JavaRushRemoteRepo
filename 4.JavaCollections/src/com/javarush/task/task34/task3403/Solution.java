package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        recurse(126);
    }
    public static void recurse(int n) {
        int prime;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                    recurse(n / i);
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

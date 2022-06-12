package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int minimum = min(a, b, c, d, e);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int e) {
        int cache = 0;
        int cache2 = 0;
        int finalCache = 0;
        if (a < b) {
            cache = a;
        }
        else {
            cache = b;
        }
        if (c < d) {
            cache2 = c;
        }
        else {
            cache2 = d;
        }
        if (cache < cache2) {
            finalCache = cache;
        }
        else {
            finalCache = cache2;
        }
        if (finalCache < e) {
            return finalCache;
        }
        else {
            return e;
        }
    }
}

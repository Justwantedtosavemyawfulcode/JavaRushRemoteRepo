package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int minByte = 2147483647; // Можно было Integer.MAX_VALUE;
        int temp;
        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        while (fileInputStream.available() > 0) {
            temp = fileInputStream.read();
            if (temp < minByte) {
                minByte = temp;
            }
        }
        System.out.println(minByte);
        fileInputStream.close();
    }
}

package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxByte = 0;
        int temp;
        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        while (fileInputStream.available() > 0) {
            temp = fileInputStream.read();
            if (temp > maxByte) {
                maxByte = temp;
            }
        }
        System.out.println(maxByte);
        fileInputStream.close();
    }
}

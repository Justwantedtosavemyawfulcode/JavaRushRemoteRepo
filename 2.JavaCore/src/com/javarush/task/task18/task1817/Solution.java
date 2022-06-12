package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int spaces = 0;
        int symbols = 0;
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 32) {
                spaces++;
            }
            symbols++;
        }
        fileInputStream.close();
        float result = ((float) spaces / symbols * 100);
        result = Math.round(result * 100) / 100f;
        System.out.println(result);
    }
}

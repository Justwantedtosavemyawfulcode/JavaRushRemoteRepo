package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int symbol;
        int count = 0;
        while (fileInputStream.available() > 0) {
            symbol = fileInputStream.read();
            if (symbol == 44){
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);
    }
}

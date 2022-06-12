package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader filePath = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath.readLine()));
        filePath.close();
        String str;
        while ((str = fileReader.readLine()) != null) {
            char[] charString = str.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            System.out.println(stringBuilder.reverse());
//            for (int i = charString.length - 1; i >= 0; i--) {
//                stringBuilder.append(charString[i]);
//            }
//            System.out.println(stringBuilder);
        }
        fileReader.close();
    }
}

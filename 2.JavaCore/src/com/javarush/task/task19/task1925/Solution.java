package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while ((str = file1.readLine()) != null) {
            stringBuilder.append(str).append(" ");
        }
        file1.close();
        String[] textArray = stringBuilder.toString().split(" ");
        StringBuilder finalText = new StringBuilder();
        for (int i = 0; i < textArray.length - 1; i++) {
            if (textArray[i].length() > 6) {
                finalText.append(textArray[i]).append(",");
            }
        }
        file2.write(finalText.substring(0, finalText.length() - 1));
        file2.close();
    }
}

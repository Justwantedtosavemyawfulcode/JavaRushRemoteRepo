package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();
        StringBuilder stringBuilder = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            line = reader.readLine();
        }
        reader.close();
        String text = stringBuilder.toString().replaceAll("\\pP", "");
        writer.write(text);
        writer.close();
    }
}

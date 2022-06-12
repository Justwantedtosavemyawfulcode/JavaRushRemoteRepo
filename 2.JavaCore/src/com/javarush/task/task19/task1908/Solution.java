package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.text.ParseException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();
        StringBuilder text = new StringBuilder();
        String string = reader.readLine();
        while (string != null) {
            text.append(string);
            string = reader.readLine();
        }
        reader.close();
        String data = text.toString();
        String[] array = data.split(" ");
        for (String s:array) {
            try {
                int i = Integer.parseInt(s);
                writer.write(String.valueOf(i));
                writer.write(" ");
            }
            catch (NumberFormatException e) {

            }
        }
        writer.close();
    }
}

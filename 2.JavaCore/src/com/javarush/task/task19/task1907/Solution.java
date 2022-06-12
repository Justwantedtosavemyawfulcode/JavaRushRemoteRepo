package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();
        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.ready()) {
            int c = reader.read();
            stringBuilder.append((char) c);
        }
        reader.close();
        String data = stringBuilder.toString().toLowerCase();
        // System.out.println(data);
        String[] text = data.split("\\W");
        for (String s:text) {
            if (s.equals("world")) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}

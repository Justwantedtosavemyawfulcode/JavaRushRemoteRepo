package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader filePath = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath.readLine()));
        filePath.close();
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while ((str = fileReader.readLine()) != null) {
            stringBuilder.append(str);
            stringBuilder.append(" \n ");
        }
        fileReader.close();
        String[] text = stringBuilder.toString().split(" ");
        for (int i = 0; i < text.length; i++) {
            try {
                int oneTwelve = Integer.parseInt(text[i]);
                if (oneTwelve >= 0 && oneTwelve < 13) {
                    text[i] = map.get(oneTwelve);
                }
            }
            catch (NumberFormatException e) {

            }
        }
        StringBuilder finalText = new StringBuilder();
        for (String s:text) {
            if (s == null) {
                break;
            }
            if (s.equals("")) {
                continue;
            }
            if (s.contains("\n")) {
                finalText.append("\n");
                continue;
            }
            finalText.append(s).append(" ");
        }
        System.out.println(finalText);
    }
}

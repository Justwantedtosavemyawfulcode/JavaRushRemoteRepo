package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader filePath = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath.readLine()));
        filePath.close();
        String str;
        StringBuilder text = new StringBuilder();
        while ((str = fileReader.readLine()) != null) {
            String[] line = str.split("\\pP| ");
            int counter = 0;
            for (String s:line) {
                if (Collections.frequency(words, s) > 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                System.out.println(str);
            }
        }
        fileReader.close();
    }
}

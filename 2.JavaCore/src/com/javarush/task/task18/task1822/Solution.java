package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        String line = file.readLine();
        while (line != null) {
            if (line.startsWith(args[0] + " ")) {
                System.out.println(line);
                file.close();
                break;
            }
            line = file.readLine();
        }
    }
}

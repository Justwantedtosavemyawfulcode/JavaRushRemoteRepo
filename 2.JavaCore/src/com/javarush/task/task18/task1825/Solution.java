package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        SortedSet<String> set = new TreeSet<>();
        String line = bufferedReader.readLine();
        String[] tmps = (line.split("\\.part"));
        String filePath = tmps[0];
        while (!(line.equals("end"))) {
            set.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
        for (String s:set) {
            FileInputStream fileInputStream = new FileInputStream(s);
            byte[] bytes = new byte[1000];
            while (fileInputStream.available() > 0) {
                int count = fileInputStream.read(bytes);
                fileOutputStream.write(bytes, 0, count);
            }
            fileInputStream.close();

        }
        fileOutputStream.close();
    }
}

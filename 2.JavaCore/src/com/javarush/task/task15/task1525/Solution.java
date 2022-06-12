package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(Statics.FILE_NAME));
            String str = bufferedReader.readLine();
            while (str != null) {
                lines.add(str);
                str = bufferedReader.readLine();
            }
        }

        catch (IOException e) {

        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(lines);
    }
}

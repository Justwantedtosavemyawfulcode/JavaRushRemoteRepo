package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath1 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileReader fileReader1 = new FileReader(filePath1);
        BufferedReader bufferedReader = new BufferedReader(fileReader1);
        String line = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line);
            line = bufferedReader.readLine();
        }
        String file1Content = sb.toString();
        bufferedReader.close();

        FileWriter file1Writer = new FileWriter(filePath1);
        String filePath2 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        BufferedReader fileReader2 = new BufferedReader(new FileReader(filePath2));
        line = fileReader2.readLine();
        sb = new StringBuilder();
        while (line != null) {
            sb.append(line);
            line = fileReader2.readLine();
        }
        file1Writer.write(sb.toString());
        file1Writer.write(file1Content);
        file1Writer.close();
        fileReader2.close();
    }
}

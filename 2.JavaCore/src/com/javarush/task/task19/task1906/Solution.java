package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        bufferedReader.close();
        int counter = 0;
        while (fileReader.ready()) {
            int data = fileReader.read();
            if (counter % 2 != 0) {
                fileWriter.write(data);
            }
            counter++;
        }
        fileReader.close();
        fileWriter.close();
    }
}

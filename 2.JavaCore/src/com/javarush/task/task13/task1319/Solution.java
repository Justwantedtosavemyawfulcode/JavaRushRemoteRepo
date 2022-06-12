package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String string = bufferedReader.readLine();
        while (!(string.equals("exit"))) {
            bufferedWriter.write(string + "\n");
            string = bufferedReader.readLine();
        }
        bufferedWriter.write(string + "\n");
        bufferedWriter.close();
        bufferedReader.close();
        fileWriter.close();
        // напишите тут ваш код
    }
}

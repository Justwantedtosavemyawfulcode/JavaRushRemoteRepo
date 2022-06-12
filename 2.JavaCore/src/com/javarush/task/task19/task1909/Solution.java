package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();
        int i = reader.read();
        while (i != -1) {
            if ((char) i == '.') {
                writer.write('!');
            }
            else {
                writer.write(i);
            }
            i = reader.read();
        }
        reader.close();
        writer.close();
    }
}

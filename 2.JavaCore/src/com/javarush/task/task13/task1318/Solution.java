package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        InputStream inputStream = new FileInputStream(fileName);
        // BufferedInputStream buffer = new BufferedInputStream(inputStream);
        while (inputStream.available() > 0) {
            System.out.print((char) inputStream.read());
        }
        bufferedReader.close();
        inputStream.close();
        // напишите тут ваш код
    }
}
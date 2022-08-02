package com.javarush.task.task32.task3210;

/*
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = "C:\\Users\\leonid\\Desktop\\2.txt";
        int number = 8;
        String text = "TESTING";

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        byte[] byteText = new byte[text.length()];
        randomAccessFile.seek(number);
        randomAccessFile.read(byteText, 0, text.length());
//        String readText = Base64.getEncoder().encodeToString(byteText);
        String readText = new String(byteText);

        randomAccessFile.seek(randomAccessFile.length());
        if (readText.equals(text)) {
            randomAccessFile.write("true".getBytes());
        }
        else randomAccessFile.write("false".getBytes());
    }
}

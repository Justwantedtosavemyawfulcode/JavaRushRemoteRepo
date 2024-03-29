package com.javarush.task.task32.task3201;

/*
Запись в существующий файл
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        if (randomAccessFile.length() > number) {
            randomAccessFile.seek(number);
        }
        else {
            randomAccessFile.seek(randomAccessFile.length());
        }
        randomAccessFile.write(text.getBytes());
    }
}

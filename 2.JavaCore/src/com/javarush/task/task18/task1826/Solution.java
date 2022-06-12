package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        if (args[0].equals("-e")) {
            byte[] bytes = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                int oneByte = fileInputStream.read();
                fileOutputStream.write(oneByte + 4);
            }
        }
        if (args[0].equals("-d")) {
            byte[] bytes = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                int oneByte = fileInputStream.read();
                fileOutputStream.write(oneByte - 4);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();

    }

}

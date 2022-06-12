package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        byte[] buffer = new byte[1000];
        while (fileInputStream.available() > 0) {
            fileInputStream.read(buffer);
            String s = new String(buffer, "Windows-1251");
            buffer = s.getBytes("UTF-8");
            fileOutputStream.write(buffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}

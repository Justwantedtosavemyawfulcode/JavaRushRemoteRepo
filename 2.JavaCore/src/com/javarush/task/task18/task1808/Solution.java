package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath1 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String filePath2 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String filePath3 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileInputStream1 = new FileInputStream(filePath1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(filePath2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(filePath3);
        int div;
        if (!(fileInputStream1.available() % 2 == 0)) {
            div = (fileInputStream1.available() / 2) + 1;
        }
        else {
            div = (fileInputStream1.available() / 2);
        }
        byte[] buffer = new byte[div];
        int count = fileInputStream1.read(buffer);
        fileOutputStream2.write(buffer, 0, div);
        buffer = new byte[fileInputStream1.available()];
        count = fileInputStream1.read(buffer);
        fileOutputStream3.write(buffer, 0, count);
        fileInputStream1.close();
        fileOutputStream2.close();
        fileOutputStream3.close();
    }
}

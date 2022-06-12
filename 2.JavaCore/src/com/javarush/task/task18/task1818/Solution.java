package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1Path = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String file2Path = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String file3Path = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileOutputStream fileOutputStream1 = new FileOutputStream(file1Path, true);
        FileInputStream fileInputStream2 = new FileInputStream(file2Path);
        FileInputStream fileInputStream3 = new FileInputStream(file3Path);

        while (fileInputStream2.available() > 0) {
            fileOutputStream1.write(fileInputStream2.read());
        }
        while (fileInputStream3.available() > 0) {
            fileOutputStream1.write(fileInputStream3.read());
        }
        fileOutputStream1.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }
}

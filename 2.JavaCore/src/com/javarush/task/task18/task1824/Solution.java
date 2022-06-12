package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        while (true) {
            String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
            try {
                FileInputStream fileInputStream = new FileInputStream(filePath);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(filePath);
                break;
            }
        }
    }
}

package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        while (true) {
            String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            if (fileInputStream.available() < 1000) {
                fileInputStream.close();
                throw new DownloadException();
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}

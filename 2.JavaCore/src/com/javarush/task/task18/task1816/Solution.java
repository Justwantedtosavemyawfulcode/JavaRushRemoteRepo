package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int engLetterCounter = 0;
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available() > 0) {
            int letter = fileInputStream.read();
            if (((letter >= 97) && (letter <= 122)) || ((letter >= 65) && (letter <= 90))) {
                engLetterCounter++;
            }
        }
        fileInputStream.close();
        System.out.println(engLetterCounter);
    }
}

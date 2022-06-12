package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter(args[1]));
        String str;
        StringBuilder text = new StringBuilder();
        while ((str = fileReader1.readLine()) != null) {
            text.append(str).append(" ");
        }
        fileReader1.close();
        String[] arrayText = text.toString().split(" ");
        for (String s:arrayText) {
            for (Character c:s.toCharArray()) {
                if (Character.isDigit(c)) {
                    fileWriter2.write(s + " ");
                    break;
                }
            }
        }
        fileWriter2.close();
    }
}

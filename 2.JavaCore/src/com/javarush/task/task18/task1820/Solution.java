package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        FileWriter file2 = new FileWriter(new BufferedReader(new InputStreamReader(System.in)).readLine());
        String fileContent = file1.readLine();
        ArrayList<String> lines = new ArrayList<>(Arrays.asList(fileContent.split(" ")));
        file1.close();
        for (int h = 0; h < lines.size(); h++) {
            char[] charLine = lines.get(h).toCharArray();
            String number = "";
            if (!(lines.get(h).contains("."))) {
                number = getNumber(charLine);
            }
            for (int i = 1; i < charLine.length; i++) {
                if (charLine[i] == '.') {
                    ArrayList<Character> arl = new ArrayList<Character>();
                    for (int j = i + 1; j < charLine.length; j++) {
                        arl.add(charLine[j]);
                    }
                    boolean flag = false;
                    if (Integer.parseInt(String.valueOf(arl.get(0))) >= 5) {
                        if (charLine[0] == '-') {
                            for (int j = 1; j < arl.size(); j++) {
                                if (Integer.parseInt(String.valueOf(arl.get(j))) > 0) {
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        else {
                            flag = true;
                        }
                    }
                    if (flag) {
                        charLine[i - 1] += 1;
                    }
//                    StringBuilder stringBuilder = new StringBuilder();
//                    stringBuilder.append(charLine[i + 1]).append(charLine[i + 2]);
//                    if (Integer.parseInt(stringBuilder.toString()) >= 51) {
//                        charLine[i - 1] += 1;
//                    }
                }
                else {
                    continue;
                }
                number = getNumber(charLine);
            }
            file2.write(number + " ");

        }
        file2.close();
    }

    public static String getNumber(char[] charLine) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:charLine) {
            if (c == '.') {
                break;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

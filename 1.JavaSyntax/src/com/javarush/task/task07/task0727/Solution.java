package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();
        while (true) {
            String string = reader.readLine();
            if (string == null || string.isEmpty()) break;
            strings.add(string);
        }

        ArrayList<String> resultStrings = new ArrayList<String>();
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            if (string.length() % 2 == 0) {
                resultStrings.add(multiply(2, (strings.get(i))));
            }
            else  {
                resultStrings.add(multiply(3, (strings.get(i))));
            }
        }

        for (int i = 0; i < resultStrings.size(); i++) {
            System.out.println(resultStrings.get(i));
        }
    }
    public static String multiply(int m, String string) {
        String newString = string;
        for (int i = 0; i < m - 1; i++) {
            newString += " " + string;
        }
        return newString;
    }
}

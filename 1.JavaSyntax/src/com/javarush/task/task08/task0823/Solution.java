package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] characterArray = string.toCharArray();
        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] == ' ') {
                characterArray[i + 1] = Character.toUpperCase(characterArray[i + 1]);
        }
        }
        if (!(characterArray[0] == ' ')) {
            characterArray[0] = Character.toUpperCase(characterArray[0]);
        }
        string = "";
        for (char c: characterArray) {
            string += c;
        }
        System.out.println(string);
        //напишите тут ваш код
    }
}

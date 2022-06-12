package com.javarush.task.task09.task0923;

/* 
Гласные и согласные
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        ArrayList<Character> vowelsString = new ArrayList<>();
        ArrayList<Character> notVowelsLol = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String initialString = bufferedReader.readLine();
        for (char c: initialString.toCharArray()) {
            if (isVowel(c)) {
                vowelsString.add(c);
            }
            else {
                if (!(c == ' ')) {
                    notVowelsLol.add(c);
                }
            }
        }
        for (char c: vowelsString) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (char c: notVowelsLol) {
            System.out.print(c + " ");
        }
        //напишите тут ваш код
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}
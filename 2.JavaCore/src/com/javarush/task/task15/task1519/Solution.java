package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int integerInput;
        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("exit")) {
                break;
            }
            else {
                try {
                    char[] arrayInput = input.toCharArray();
                    if (doubleCheck(arrayInput)) {
                        print(Double.parseDouble(input));
                        continue;
                    }
                    else {
                        integerInput = Integer.parseInt(input);
                        if (shortCheck(integerInput)) {
                            print(Short.parseShort(input));
                            continue;
                        }
                        else {
                            print(integerInput);
                        }
                    }

                }
                catch (NumberFormatException e) {
                    print(input);
                }
                continue;
            }
        }
        //напиште тут ваш код
    }

    public static boolean doubleCheck(char[] charArray) {
        boolean numberIsDouble = false;
        for (char c: charArray) {
            if (c == '.') {
                numberIsDouble = true;
            }

        }
        return numberIsDouble;
    }
    public static boolean shortCheck(int i) {
        if (i > 0 && i < 128) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

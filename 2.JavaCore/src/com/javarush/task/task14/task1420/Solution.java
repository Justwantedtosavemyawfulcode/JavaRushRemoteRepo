package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int FirstNumber = fillNumberFlag();
        int SecondNumber = fillNumberFlag();
        if (FirstNumber < 1 | SecondNumber < 1) {
            throw new IOException("Введено отрицательное число");
        }
        if (FirstNumber > SecondNumber) {
            System.out.println(division(FirstNumber, SecondNumber));
        }
        else {
            System.out.println(division(SecondNumber, FirstNumber));
        }



    }

    private static int fillNumberFlag() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringNumberJustForRemembering = bufferedReader.readLine();
        return Integer.parseInt(stringNumberJustForRemembering);

    }

    public static int division(int number1, int number2) {
        int posNumber = number1 / number2;
        int ostNumber = number1 % number2;
        int result = 0;
        if (!(ostNumber == 0)) {
            result = division(number2, ostNumber);;
        }
        else {
            return number2;
        }
        return result;
    }
}

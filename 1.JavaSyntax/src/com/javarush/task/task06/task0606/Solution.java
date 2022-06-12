package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even = 0;
    public static int odd = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String num = bufferedReader.readLine();
        String lenNumber = num;
        for (int i = 0; i < lenNumber.length(); i++) {
            int number = Integer.parseInt(num);
            if (number % 2 == 0) {
                even += 1;
        }
            else {
                odd += 1;
            }
            number = number / 10;
            num = Integer.toString(number);


        }
        System.out.println("Even: " + even + " " + "Odd: " + odd);
        //напишите тут ваш код
    }
}

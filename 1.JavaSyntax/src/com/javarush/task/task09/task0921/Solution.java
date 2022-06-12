package com.javarush.task.task09.task0921;

/* 
Метод в try..catch
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
            ArrayList<Integer> numbers = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (true) {
                    numbers.add(Integer.parseInt(bufferedReader.readLine()));
                }
            }
            catch (Exception e) {
                for (int num: numbers) {
                    System.out.println(num);
                }
            }
        //напишите тут ваш код
    }
}

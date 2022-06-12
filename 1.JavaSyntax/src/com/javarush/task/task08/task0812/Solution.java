package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intList.add(Integer.parseInt(bufferedReader.readLine()));
        }
        int counter = 1;
        int finalCounter = 0;
        int previousNumber = 0;
        Iterator<Integer> iterator = intList.iterator();
        iterator.next();
        for (int num: intList) {
            if (num == previousNumber) {
                counter++;
            }
            else {
                counter = 1;
            }
            if (counter > finalCounter) {
                finalCounter = counter;
            }
            previousNumber = num;
        }
        System.out.println(finalCounter);
        //напишите тут ваш код

    }
}
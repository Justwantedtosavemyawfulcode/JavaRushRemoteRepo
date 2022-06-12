package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min = array.get(0);
        for (int num: array) {
            if (num < min) {
                min = num;
            }
        }
        // Найти минимум тут
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(Integer.parseInt(bufferedReader.readLine()));
        }
        // Создать и заполнить список тут
        return array;
    }
}

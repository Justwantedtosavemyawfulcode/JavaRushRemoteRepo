package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String s = bufferedReader.readLine();
            list.add(s);
        }
        // Считать строки с консоли и объявить ArrayList list тут

        ArrayList<String> result = doubleValues(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        // Вывести на экран result
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i = 1; i < list.size(); i+=2) {
            list.add(i, list.get(i - 1));
        }
        list.add(list.size() - 1, list.get(list.size() - 1));
        //напишите тут ваш код
        return list;
    }
}

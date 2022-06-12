package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] lst = new ArrayList[2];
        lst[0] = new ArrayList<String>(Arrays.asList("hello1", "hello2"));
        lst[1] = new ArrayList<String>(Arrays.asList("hello3", "hello4"));
        //напишите тут ваш код

        return lst;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
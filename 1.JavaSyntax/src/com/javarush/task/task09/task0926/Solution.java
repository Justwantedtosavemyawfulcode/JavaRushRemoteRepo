package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> lst = new ArrayList<int[]>();
        lst.add(new int[]{1, 2, 3, 4, 5});
        lst.add(new int[]{1, 2});
        lst.add(new int[]{1, 2, 3, 4});
        lst.add(new int[]{1, 2, 3, 4, 5, 6, 7});
        lst.add(new int[]{});
        return lst;
        //напишите тут ваш код
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}

package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;

        while (i < 11) {
            while (j < 11) {
                System.out.print(i * j);
                System.out.print(" ");
                j++;
            }
            System.out.println();
            i++;
            j = 1;
        }
        //напишите тут ваш код

    }
}

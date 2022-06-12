package com.javarush.task.task08.task0807;

/* 
LinkedList и ArrayList
*/

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static Object createArrayList() {
        return new ArrayList();
        //напишите тут ваш код

    }

    public static Object createLinkedList() {
        return new LinkedList();
        //напишите тут ваш код

    }

    public static void main(String[] args) {
        ArrayList lst = new ArrayList();
        lst.add("sada");
        lst.add(5);
        Cat mya = new Cat();
        lst.add(mya);
        System.out.println(lst);
    }

    public static class Cat {
        String name = "Mya";

        @Override
        public String toString() {
            return name;
        }
    }
}

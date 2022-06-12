package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        cats.remove(cats.iterator().next());

        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static class Cat {
    }

    public static Set<Cat> createCats() {
        Set<Cat> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(new Cat());
        }
        //напишите тут ваш код. step 2 - пункт 2
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat cat: cats) {
            System.out.println(cat);
        }
        // step 4 - пункт 4
    }

    // step 1 - пункт 1
}

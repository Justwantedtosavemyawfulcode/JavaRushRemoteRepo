package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;

        // напишите тут ваш код

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 10) {
                iterator.remove();
            }
        }
        return set;
        // напишите тут ваш код

    }

    public static void main(String[] args) {
    }
}

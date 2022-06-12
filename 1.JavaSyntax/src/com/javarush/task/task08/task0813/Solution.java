package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        Set<String> set = new HashSet<>();
        String dvigatelProgressa = "Лось";
        for (int i = 1; i < 21; i++) {
            set.add(dvigatelProgressa + i);
        }
        return set;
        //напишите тут ваш код

    }


    public static void main(String[] args) {

    }

}

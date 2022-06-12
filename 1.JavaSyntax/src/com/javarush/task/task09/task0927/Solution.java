package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> map = new HashMap<>();
        map.put("Murzik", new Cat("Murzik"));
        map.put("Murzik2", new Cat("Murzik2"));
        map.put("Murzik3", new Cat("Murzik3"));
        map.put("Murzik4", new Cat("Murzik4"));
        map.put("Murzik5", new Cat("Murzik5"));
        map.put("Murzik6", new Cat("Murzik6"));
        map.put("Murzik7", new Cat("Murzik7"));
        map.put("Murzik8", new Cat("Murzik8"));
        map.put("Murzik9", new Cat("Murzik9"));
        map.put("Murzik10", new Cat("Murzik10"));
        return map;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catSet = new HashSet<>();
        for (Map.Entry<String, Cat> pair: map.entrySet()) {
            catSet.add(pair.getValue());
        }
        return catSet;
        //напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}

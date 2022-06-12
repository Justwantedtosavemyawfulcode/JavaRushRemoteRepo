package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Фамилия", "Имя");
        map.put("ываыыфв", "выа");
        map.put("Фамилия", "Иолппмя");
        map.put("паввы", "Имя");
        map.put("выывфя", "Имя");
        map.put("ваывыамсч", "Имя");
        map.put("уцкецуеку", "Имя");
        map.put("выамсч", "Имя");
        map.put("гопрв", "Имя");
        map.put("уунепавч", "Имя");
        //напишите тут ваш код

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}

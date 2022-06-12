package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> dict = new HashMap<>();
        dict.put("Петров", "Иван");
        dict.put("Иванов", "Петр");
        dict.put("ыфв", "ывф");
        dict.put("Петрова", "ваы");
        dict.put("еу", "ра");
        dict.put("ячс", "им");
        dict.put("екра", "ыаф");
        dict.put("чясячс", "Иван");
        dict.put("мсчсчмчс", "Иван");
        dict.put("мчыый", "Иван");
        return dict;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int counter = 0;
        for (Map.Entry<String, String> pair: map.entrySet()) {
            String initialName = pair.getValue();
            if (initialName.equals(name)) {
                counter += 1;
            }
        }
        return counter;
        //напишите тут ваш код

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int counter = 0;
        for (Map.Entry<String, String> pair: map.entrySet()) {
            String initialName = pair.getKey();
            if (initialName.equals(lastName)) {
                counter += 1;
            }
        }
        return counter;
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}

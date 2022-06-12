package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<String, String> dict = new HashMap<>();
        dict.put("арбуз", "ягода");
        dict.put("банан", "трава");
        dict.put("вишня", "ягода");
        dict.put("груша", "фрукт");
        dict.put("дыня", "овощ");
        dict.put("ежевика", "куст");
        dict.put("жень-шень", "корень");
        dict.put("земляника", "ягода");
        dict.put("ирис", "цветок");
        dict.put("картофель", "клубень");
        for (Map.Entry<String, String> pair: dict.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
        //напишите тут ваш код

    }
}

package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Фамилия", 499);
        map.put("fsad", 16);
        map.put("ewrw", 642);
        map.put("gsddsgcx", 6452);
        map.put("sadasda", 454);
        map.put("ewqfs", 321);
        map.put("sfhhhg", 641);
        map.put("vcxx", 700);
        map.put("xzzs", 213);
        map.put("asdy", 666);
        return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> cache = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> pair: cache.entrySet()) {
            if (pair.getValue() < 500) {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }
        //напишите тут ваш код
    }

    public static void removeItemFromMapByValue(Map<String, Integer> map, int value) {
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() == value) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = createMap();
        removeItemFromMap(map);
    }
}
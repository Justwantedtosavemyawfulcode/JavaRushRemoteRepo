package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Фамилия", "ss");
        map.put("fsad", "bb");
        map.put("ewrw", "eee");
        map.put("gsddsgcx", "Имя");
        map.put("sadasda", "qq");
        map.put("ewqfs", "ff");
        map.put("sfhhhg", "Имя");
        map.put("vcxx", "dd");
        map.put("xzzs", "Имя");
        map.put("asdy", "Имя");
        return map;
        //напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> dictCopy = new HashMap<>(map);
        String badName = "";
        for (Map.Entry<String, String> pair: dictCopy.entrySet()) {
            String lastName = pair.getKey();
            String name = pair.getValue();
            for (Map.Entry<String, String> pair2: dictCopy.entrySet()) {
                String lastName2 = pair2.getKey();
                String name2 = pair2.getValue();
                if (name.equals(name2) && (!(lastName.equals(lastName2)))) {
                    removeItemFromMapByValue(map, name2);
                }
            }
        }
        //напишите тут ваш код

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> dict = createMap();
        removeTheFirstNameDuplicates(dict);

    }
}

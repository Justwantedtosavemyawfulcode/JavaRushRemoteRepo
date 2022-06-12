package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
//        map.put("name", "Ivanov");
//        map.put("age", null);
//        map.put("country", "Russia");
//        map.put("City", "Moscow");
        map.put(null, null);
        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String>entry:params.entrySet()) {
            if (!((entry.getKey() == null) || (entry.getValue() == null))) {
                stringBuilder.append(String.format("%s = '%s' and ", entry.getKey(), entry.getValue()));
            }
        }
        if (stringBuilder.length() > 5) {
            stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length());
        }
        return stringBuilder.toString();
    }
}

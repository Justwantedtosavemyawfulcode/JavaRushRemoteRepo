package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c: alphabet) {
            map.put(c, 0);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        for (String s: list) {
            for (char c: s.toCharArray()) {
                for (Map.Entry<Character, Integer> pair: map.entrySet()) {
                    if (pair.getKey() == c) {
                        map.put(pair.getKey(), pair.getValue() + 1);
                    }
                }
            }
        }
        for (Map.Entry<Character, Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        // напишите тут ваш код
    }
}

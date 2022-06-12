package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        TreeMap<Character, Integer> map = new TreeMap<>();
        while (fileInputStream.available() > 0) {
            byte[] byteChar = new byte[1];
            int byteInt = fileInputStream.read(byteChar);
            char symbol = (char) (byte) byteChar[0];
            if (map.containsKey(symbol)) {
                map.put(symbol, map.get(symbol) + 1);
            }
            else {
                map.put(symbol, 1);
            }
        }
        fileInputStream.close();
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }

    }
}

package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxEntities = 0;
        int temp;
        String filePath = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        while (fileInputStream.available() > 0) {
            temp = fileInputStream.read();
            if (!(map.containsKey(temp))) {
                map.put(temp, 1);
            }
            else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        fileInputStream.close();

        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue() > maxEntities) {
                maxEntities = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue() == maxEntities) {
                list.add(entry.getKey());
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.get(list.size() - 1));
    }
}

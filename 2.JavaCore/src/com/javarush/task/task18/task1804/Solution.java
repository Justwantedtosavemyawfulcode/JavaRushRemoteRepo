package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int minEntities = Integer.MAX_VALUE;
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
            if (entry.getValue() < minEntities) {
                minEntities = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue() == minEntities) {
                list.add(entry.getKey());
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.get(list.size() - 1));
    }
}

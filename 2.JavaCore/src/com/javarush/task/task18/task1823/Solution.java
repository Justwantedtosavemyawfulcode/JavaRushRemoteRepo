package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        while (!(line.equals("exit"))) {
            new ReadThread(line).start();
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static class ReadThread extends Thread {
        FileInputStream fileInputStream;
        String fileName;

        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
            fileInputStream = new FileInputStream(fileName);
            // implement file reading here - реализуйте чтение из файла тут
        }

        public void run() {
            TreeMap<Character, Integer> map = new TreeMap<>();
            while (true) {
                try {
                    if (!(fileInputStream.available() > 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] byteChar = new byte[1];
//                try {
//                    int byteInt = fileInputStream.read(byteChar);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                char symbol = 0;
                try {
                    symbol = (char) (byte) fileInputStream.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (map.containsKey(symbol)) {
                    map.put(symbol, map.get(symbol) + 1);
                } else {
                    map.put(symbol, 1);
                }
            }
            int maxIteration = 0;
            for (Map.Entry<Character, Integer> entry:map.entrySet()) {
                if (entry.getValue() > maxIteration) {
                    maxIteration = entry.getValue();
                }
            }
            for (Map.Entry<Character, Integer> entry2:map.entrySet()) {
                if (entry2.getValue() == maxIteration) {
                    resultMap.put(fileName, (int) (byte) (char) entry2.getKey());
                }
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

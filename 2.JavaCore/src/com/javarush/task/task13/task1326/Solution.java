package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> evenNumbersList = new ArrayList<>();
        String stringOfNumbers = bufferedReader.readLine();
        Integer num;
        while (!(stringOfNumbers == null)) {
            num = Integer.parseInt(stringOfNumbers);
            arrayList.add(num);
            stringOfNumbers = bufferedReader.readLine();
        }
        for (Integer i: arrayList) {
            if (i % 2 == 0) {
                evenNumbersList.add(i);
            }
        }


        for (int i = 0; i < evenNumbersList.size(); i++) {
            for (int j = 0; j < evenNumbersList.size(); j++) {
                if (evenNumbersList.get(i) < evenNumbersList.get(j)) {
                    Integer cache = evenNumbersList.get(i);
                    evenNumbersList.set(i, evenNumbersList.get(j));
                    evenNumbersList.set(j, cache);
                }
            }
        }
        for (Integer i : evenNumbersList) {
            System.out.println(i);
        }
        bufferedReader.close();
    }
        // напишите тут ваш код
}

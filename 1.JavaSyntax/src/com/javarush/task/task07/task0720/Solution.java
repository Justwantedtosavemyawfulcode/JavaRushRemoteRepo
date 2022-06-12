package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> lst = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            lst.add(s);
        }
        for (int i = 0; i < m; i++) {
            lst.add(lst.remove(0));
        }
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }

        //напишите тут ваш код
    }
}

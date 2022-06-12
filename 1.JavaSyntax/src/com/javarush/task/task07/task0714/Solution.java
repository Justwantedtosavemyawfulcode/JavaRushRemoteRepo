package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lst = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = bufferedReader.readLine();
            lst.add(s);
        }
        lst.remove(2);
        for (int i = lst.size() - 1; i >= 0; i--) {
            System.out.println(lst.get(i));
        }
        //напишите тут ваш код
    }
}

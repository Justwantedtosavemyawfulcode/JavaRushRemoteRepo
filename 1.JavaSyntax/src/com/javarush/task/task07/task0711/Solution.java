package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lst = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = bufferedReader.readLine();
            lst.add(s);
        }
        for (int i = 0; i < 13; i++) {
            lst.add(0, lst.get(lst.size() -1));
            lst.remove(lst.size() -1);
        }
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
        //напишите тут ваш код
    }
}

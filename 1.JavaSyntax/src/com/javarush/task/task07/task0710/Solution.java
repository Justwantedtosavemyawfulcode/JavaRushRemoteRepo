package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lst = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String s = bufferedReader.readLine();
            lst.add(0, s);
        }
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
        //напишите тут ваш код
    }
}

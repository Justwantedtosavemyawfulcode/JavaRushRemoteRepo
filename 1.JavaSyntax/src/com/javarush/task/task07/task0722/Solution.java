package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lst = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (true) {
            s = reader.readLine();
            if (!(s.equals("end")))
                lst.add(s);
            else
                break;
        }
        for (String value:
             lst) {
            System.out.println(value);
        }
        //напишите тут ваш код
    }
}
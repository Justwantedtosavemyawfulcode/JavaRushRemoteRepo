package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lst = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lenCounter = 0;
        for (int i = 0; i < 10; i++) {
            String s = bufferedReader.readLine();
            lst.add(s);
        }
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).length() >= lenCounter) {
                lenCounter = lst.get(i).length();
            }
            else {
                System.out.println(i);
                break;
            }
        }
        //напишите тут ваш код
    }
}


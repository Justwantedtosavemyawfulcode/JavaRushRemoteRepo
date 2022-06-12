package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            lst.add(num);
        }
        Collections.sort(lst);
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
        //напишите тут ваш код
    }
}

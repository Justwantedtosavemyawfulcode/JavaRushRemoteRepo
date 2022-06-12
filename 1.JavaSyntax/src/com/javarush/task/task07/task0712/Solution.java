package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lst = new ArrayList<String>();
        ArrayList<Integer> minIndexList= new ArrayList<Integer>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int maxLen = 0;
        int maxIndex = 0;
        int minLen = 0;
        int minIndex = 0;
        for (int i = 0; i < 10; i++) { // ДЕСЯТЬ
            String s = bufferedReader.readLine();
            lst.add(s);
        }
        for (int i = 0; i < lst.size(); i++) {
            minIndexList.add(lst.get(i).length());
        }
        for (int i = 0; i < minIndexList.size(); i++) {
            if (minIndexList.get(i) < minLen || minLen == 0) {
                minLen = minIndexList.get(i);
                minIndex = i;
            }
        }
        for (int i = 0; i < minIndexList.size(); i++) {
            if (minIndexList.get(i) > maxLen || maxLen == 0) {
                maxLen = minIndexList.get(i);
                maxIndex = i;
            }
        }
        if (minIndex < maxIndex) {
            System.out.println(lst.get(minIndex));
        }
        else {
            System.out.println(lst.get(maxIndex));
        }
        //напишите тут ваш код
    }
}

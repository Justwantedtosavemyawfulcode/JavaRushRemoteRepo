package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            String string = stringTokenizer.nextToken();
            arrayList.add(string);
        }
        String[] tokens = new String[arrayList.size()];
        return arrayList.toArray(tokens);
    }
}

package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        boolean lCheck = false;
        boolean rCheck = false;
        for (int i = 0; i < strings.size(); i++) {
            for (char c : strings.get(i).toCharArray()) {
                if (c == 'л') {
                    lCheck = true;
                }
                if (c == 'р') {
                    rCheck = true;
                }
            }
            if (lCheck == true && rCheck == false) {
                strings.add(i, strings.get(i));
                i++;
            }
            if (lCheck == false && rCheck == true) {
                strings.remove(strings.get(i));
                i--;
            }
            lCheck = false;
            rCheck = false;
        }
        //напишите тут ваш код
        return strings;
    }
}
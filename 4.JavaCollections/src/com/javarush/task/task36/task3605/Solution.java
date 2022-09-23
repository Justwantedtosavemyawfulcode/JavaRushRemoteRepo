package com.javarush.task.task36.task3605;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        FileReader fileReader = new FileReader(file);
        TreeSet<Character> set = new TreeSet<>();
        int i;
        while ((i = fileReader.read()) != -1) {
            char c = (char) i;
            if (Character.isLetter(c)) {
                set.add(Character.toLowerCase(c));
            }
        }
        Iterator iterator = set.iterator();
        i = 0;
        while (iterator.hasNext() && i < 5) {
            i++;
            System.out.print(iterator.next());
        }
    }
}

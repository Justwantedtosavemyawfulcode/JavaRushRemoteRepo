package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static class Idea {
        public String getDescription() {
            return "aaa";
        }
    }
    public static void printIdea(Idea idea) {
        System.out.println(idea.getDescription());
    }
    public static void main(String[] args) throws IOException {

        printIdea(new Idea());
    }

    //напишите тут ваш код
}

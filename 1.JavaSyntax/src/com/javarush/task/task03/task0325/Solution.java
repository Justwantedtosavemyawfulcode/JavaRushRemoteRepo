package com.javarush.task.task03.task0325;

import java.io.*;
import java.util.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cacheBucks = bufferedReader.readLine();
        int bucks = Integer.parseInt(cacheBucks);

        System.out.println("Я буду зарабатывать $" + bucks + " в час");

    }
}

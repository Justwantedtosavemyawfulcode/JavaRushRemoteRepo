package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            int num = Integer.parseInt(bufferedReader.readLine());
            sum += num;
            if (num == -1) {
                System.out.println(sum);
                break;
            }
        }
        //напишите тут ваш код

    }
}

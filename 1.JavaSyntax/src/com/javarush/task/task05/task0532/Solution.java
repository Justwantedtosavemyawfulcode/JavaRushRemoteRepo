package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maximum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (num > maximum || maximum == 0) {
                maximum = num;
            }



        }
        //напишите тут ваш код

        if (maximum != 0) {
            System.out.println(maximum);
        }
    }
}

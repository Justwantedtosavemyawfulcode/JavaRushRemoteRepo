package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        float sum = 0;
        int count = 0;

        while (true) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if (!(num == -1)) {
                sum += num;
                count += 1;
            }
            else {
                System.out.println(sum / count);
                break;
            }
        }
        //напишите тут ваш код
    }
}


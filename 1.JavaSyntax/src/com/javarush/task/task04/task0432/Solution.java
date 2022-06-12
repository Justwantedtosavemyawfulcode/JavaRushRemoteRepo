package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        int num = Integer.parseInt(bufferedReader.readLine());
        int i = 0;

        while (i < num) {
            System.out.println(string);
            i++;
        }
        //напишите тут ваш код

    }
}

package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        bufferedReader.close();
        if (string.equals("helicopter")) {
            result = new Helicopter();
        }
        if (string.equals("plane")) {
            BufferedReader bufferedReaderInt = new BufferedReader(new InputStreamReader(System.in));
            int passangers = Integer.parseInt(bufferedReaderInt.readLine());
            bufferedReaderInt.close();
            result = new Plane(passangers);

        }
        //add your code here - добавьте код тут
    }
}

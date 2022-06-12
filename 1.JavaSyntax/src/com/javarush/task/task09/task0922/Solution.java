package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-d");
        Date inputDate = simpleDateFormat.parse(bufferedReader.readLine());
        System.out.println((new SimpleDateFormat("MMM d, yyy", Locale.ENGLISH).format(inputDate)).toUpperCase());
        //напишите тут ваш код
    }
}

package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws ParseException, IOException {
        System.out.println(isDateOdd("MAY 1 2013"));

    }

    public static boolean isDateOdd(String date) throws ParseException {
        boolean isOdd = false;
        SimpleDateFormat parser = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        Calendar inputDate = Calendar.getInstance();
        inputDate.setTime(parser.parse(date));
        if (inputDate.get(Calendar.DAY_OF_YEAR) % 2 != 0) {
            isOdd = true;
        }
        return isOdd;
    }
}

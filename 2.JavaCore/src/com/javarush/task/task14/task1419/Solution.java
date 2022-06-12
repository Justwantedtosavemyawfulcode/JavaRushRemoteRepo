package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }

    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.get(1);

        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            int array[] = new int[2];
            array[3] = 25;

        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            Object array[] = new Integer[2];
            array[0] = "25";

        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        Object ch = '^';

        try {
            Byte b = ((Byte) ch);

        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            String[] stringArray = new String[-2];

        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }
        try {
            String str = null;
            System.out.println(str.length());

        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        try {
            String str = "null";
            System.out.println(str.charAt(4));

        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            FileInputStream file = new FileInputStream("NotFound");

        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        try {
            String notANumber = "It is not a number";
            Integer number = Integer.parseInt(notANumber);

        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}

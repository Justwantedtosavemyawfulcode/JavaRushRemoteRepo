package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(0., "FirstString");
        labels.put(1., "SecondString");
        labels.put(2., "ThirdString");
        labels.put(3., "FourthString");
        labels.put(4., "FifthString");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}

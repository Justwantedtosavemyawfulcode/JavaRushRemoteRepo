package com.javarush.task.task36.task3602;

import java.util.*;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        List<?> list = Arrays.asList(Collections.class.getDeclaredClasses());
//        System.out.println(list);
        return (Class) list.get(14);
    }
}

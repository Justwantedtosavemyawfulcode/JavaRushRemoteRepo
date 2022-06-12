package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(111));
    }

    public static int sumDigitsInNumber(int number) {
        String num = Integer.toString(number);
        int cache = 0;
        for (char i : num.toCharArray()) {
            cache += Character.getNumericValue(i);
        }
        return cache;
        //напишите тут ваш код
    }
}
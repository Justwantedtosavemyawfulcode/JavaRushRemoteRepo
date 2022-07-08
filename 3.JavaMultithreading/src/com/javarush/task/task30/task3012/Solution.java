package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        StringBuilder stringBuilder = new StringBuilder(number + " =");
        int powCounter = 0;
        while (number > 0) {
            int moduloResult = number % 3;
            number = number / 3;
            if (moduloResult == 1) {
                stringBuilder.append(" + ").append((int) Math.pow(3, powCounter));
            }
            if (moduloResult == 2) {
                stringBuilder.append(" - ").append((int) Math.pow(3, powCounter));
                number++;
            }
            powCounter++;
        }
        System.out.println(stringBuilder.toString().trim());
        //напишите тут ваш код
    }
}
package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        Cat borzoi = new Cat("borzoi", 2, 2, 2);
        Cat ded = new Cat("ded", 2, 2, 2);
        Cat chechen = new Cat("chechen", 2, 2, 2);
        //напишите тут ваш код
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
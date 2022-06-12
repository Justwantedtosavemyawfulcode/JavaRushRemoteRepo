package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private String name;
        private int weight;
        private boolean sex;
        private String address;
        private boolean skinColor;

        public Human(String name) {
            this.name = name;
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Human(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Human(int age, boolean skinColor) {
            this.age = age;
            this.skinColor = skinColor;
        }

        public Human(int age, String name, int weight) {
            this.age = age;
            this.name = name;
            this.weight = weight;
        }

        public Human(int age, String name, int weight, boolean sex) {
            this.age = age;
            this.name = name;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(int age, String name, int weight, boolean sex, String address) {
            this.age = age;
            this.name = name;
            this.weight = weight;
            this.sex = sex;
            this.address = address;
        }

        public Human(int age, String name, int weight, boolean sex, String address, boolean skinColor) {
            this.age = age;
            this.name = name;
            this.weight = weight;
            this.sex = sex;
            this.address = address;
            this.skinColor = skinColor;
        }
        // Напишите тут ваши переменные и конструкторы
    }
}

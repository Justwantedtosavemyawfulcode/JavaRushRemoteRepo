package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man adam = new Man("Adam", 18, "Heaven");
        Woman eve = new Woman("Eve", 13, "Heaven");
        Man petya = new Man("Petr", 22, "Ust-Perdyansk");
        Woman natasha = new Woman("Natalya", 40, "Huevo-Kukuevo");
        System.out.println(adam.name + " " + adam.age + " " + adam.address);
        System.out.println(petya.name + " " + petya.age + " " + petya.address);
        System.out.println(eve.name + " " + eve.age + " " + eve.address);
        System.out.println(natasha.name + " " + natasha.age + " " + natasha.address);
        //напишите тут ваш код
    }

    public static class Man {
        String name;
        int age;
        String address;

        public Man(String name) {
            this.name = name;
        }

        public Man(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman {
        String name;
        int age;
        String address;

        public Woman(String name) {
            this.name = name;
        }

        public Woman(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    //напишите тут ваш код
}

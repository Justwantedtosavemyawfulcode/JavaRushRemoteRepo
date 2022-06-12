package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name;
    int age;
    int weight;
    String color;
    String address;

    public Cat(String name) {
        this.name = name;
        this.age = 2;
        this.weight = 2;
        this.color = "Blue";
        this.address = null;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Blue";
        this.address = null;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.weight = 2;
        this.age = age;
        this.color = "Blue";
        this.address = null;
    }

    public Cat(int weight, String color) {
        this.name = null;
        this.weight = weight;
        this.color = color;
        this.age = 4;
        this.address = null;
    }

    public Cat(int weight, String color, String address) {
        this.name = null;
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 4;
    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}

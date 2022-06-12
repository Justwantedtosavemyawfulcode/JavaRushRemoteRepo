package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;
    public int tst;

    public Circle() {
        this.x = 0;
        this.y = 1;
        this.radius = 1.48888888888;
        this.tst = 9;
    }

    public Circle(double x, double y, double radius, int tst) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.tst = tst;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(double x) {
        this.x = x;
    }

    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
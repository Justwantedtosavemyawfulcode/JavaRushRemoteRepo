package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int cat1Score = 0;
        int cat2Score = 0;

        if (this.age > anotherCat.age) {
            cat1Score += 1;
        }
        if (this.age < anotherCat.age) {
            cat2Score += 1;
        }
        if (this.weight > anotherCat.weight) {
            cat1Score += 1;
        }
        if (this.weight < anotherCat.weight) {
            cat2Score += 1;
        }
        if (this.strength > anotherCat.strength) {
            cat1Score += 1;
        }
        if (this.strength < anotherCat.strength) {
            cat2Score += 1;
        }

        if (!(cat1Score == cat2Score)) {
            return cat1Score > cat2Score;
        }
        else {
            return false;
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {



    }
}

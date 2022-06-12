package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public class Dog implements CanMove, CanEat {
        public void eat() {
            System.out.println("Eating");
        }
        public void move() {
            System.out.println("Moving");
        }
    }

    public class Duck implements CanEat, CanMove, CanFly {
        public void eat() {
            System.out.println("Eating");
        }
        public void move() {
            System.out.println("Moving");
        }
        public void fly() {
            System.out.println("Flying");
        }
    }

    public class Car implements CanMove {
        public void move() {
            System.out.println("Riding");
        }
    }

    public class Airplane implements CanFly, CanMove {
        public void move() {
            System.out.println("Preparing to takeoff");
        }
        public void fly() {
            System.out.println("Flying");
        }
    }
}

package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    public class Human implements CanRun, CanSwim {
        public void run() {
            System.out.println("Running");
        }
        public void swim() {
            System.out.println("Swimming");
        }
    }

    public class Duck implements CanSwim, CanRun, CanFly {
        public void run() {
            System.out.println("Running");
        }
        public void swim() {
            System.out.println("Swimming");
        }
        public void fly() {
            System.out.println("Flying");
        }
    }

    public class Penguin implements CanRun, CanSwim {
        public void run() {
            System.out.println("Running");
        }
        public void swim() {
            System.out.println("Swimming");
        }
    }

    public class Airplane implements CanRun, CanFly {
        public void run() {
            System.out.println("Running");
        }
        public void fly() {
            System.out.println("Flying");
        }
    }
}

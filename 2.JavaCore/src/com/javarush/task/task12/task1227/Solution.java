package com.javarush.task.task12.task1227;

/* 
CanFly, CanRun, CanSwim для классов Duck, Penguin, Toad
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

    public class Duck implements CanRun, CanSwim, CanFly {
        public void swim() {
            System.out.println("Swimming");
        }
        public void run() {
            System.out.println("Running");
        }
        public void fly() {
            System.out.println("Flying");
        }


    }

    public class Penguin implements CanRun, CanSwim {
        public void swim() {
            System.out.println("Swimming");
        }
        public void run() {
            System.out.println("Running");
        }
    }

    public class Toad implements CanSwim {
        public void swim() {
            System.out.println("Swimming");
        }
    }
}

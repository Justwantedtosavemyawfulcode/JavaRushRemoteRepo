package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {
        Pet child = new Cat();
        String name = "Cat";
        public String getName() {
            return name;
        }

        @Override
        public Pet getChild() {
            return child;
        }

    }

    public static class Dog extends Pet {
        Pet child = new Dog();
        String name = "Cat";
        public String getName() {
            return name;
        }

        @Override
        public Pet getChild() {
            return child;
        }

    }
}

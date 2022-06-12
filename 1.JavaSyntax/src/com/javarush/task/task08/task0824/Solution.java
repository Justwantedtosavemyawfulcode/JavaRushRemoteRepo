package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human ded1 = new Human("Ded1", true, 70);
        Human ded2 = new Human("Ded2", true, 76);
        Human babka1 = new Human("Babka1", false, 76);
        Human babka2 = new Human("Babka2", false, 76);
        Human batya = new Human("Batya", true, 40);
        Human maman = new Human("Maman", false, 22);
        Human kid1 = new Human("kid1", false, 12);
        Human kid2 = new Human("kid2", false, 11);
        Human kid3 = new Human("kid3", true, 10);
        ded1.children.add(batya);
        ded2.children.add(maman);
        babka1.children.add(batya);
        babka2.children.add(maman);
        batya.children.add(kid1);
        batya.children.add(kid2);
        batya.children.add(kid3);
        maman.children.add(kid1);
        maman.children.add(kid2);
        maman.children.add(kid3);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(babka1);
        System.out.println(babka2);
        System.out.println(batya);
        System.out.println(maman);
        System.out.println(kid1);
        System.out.println(kid2);
        System.out.println(kid3);

        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

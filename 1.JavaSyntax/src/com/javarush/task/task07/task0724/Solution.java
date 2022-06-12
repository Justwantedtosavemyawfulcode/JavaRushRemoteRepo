package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human joe = new Human("Joe", true, 44);
        Human joe1 = new Human("Joe1", true, 45);
        Human joe2 = new Human("Joe2", true, 46);
        Human joe3 = new Human("Joe3", true, 47);
        Human joe5 = new Human("Joe5", true, 47, joe1, joe2);
        Human joe6= new Human("Joe6", true, 47, joe1, joe2);
        Human joe7 = new Human("Joe7", true, 47, joe1, joe2);
        Human joe8 = new Human("Joe8", true, 47, joe1, joe2);
        Human joe9 = new Human("Joe9", true, 47, joe6, joe7);
        System.out.println(joe);
        System.out.println(joe1);
        System.out.println(joe2);
        System.out.println(joe3);
        System.out.println(joe5);
        System.out.println(joe6);
        System.out.println(joe7);
        System.out.println(joe8);
        System.out.println(joe9);
        // напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        // напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}
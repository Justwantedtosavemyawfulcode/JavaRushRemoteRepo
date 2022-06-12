package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.addAll;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        for (int i = 0; i < 4; i++) {
            result.add(new Cat());

        }
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> result = new HashSet<Dog>();
        for (int i = 0; i < 3; i++) {
            result.add(new Dog());
        }

        //напишите тут ваш код

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> result = new HashSet<>(cats);
        result.addAll(dogs);
        //напишите тут ваш код
        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Set<Object> cache = new HashSet<>(pets);
        for (Object o: cache) {
            if (o instanceof Cat && cats.contains(o)) {
                pets.remove(o);
            }
        }
        //напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {
        for (Object o: pets) {
            System.out.println(o);
        }
        //напишите тут ваш код
    }

    public static class Cat {

    }

    public static class Dog {

    }
    //напишите тут ваш код
}

package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>...vararg) {
            comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
            for (Comparator<T> comparator : comparators) {
                int resultOfCompare = comparator.compare(o1, o2);
                if (resultOfCompare != 0) {
                    return resultOfCompare;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        CarTest car1 = new CarTest(100000, 300, "KIA");
        CarTest car2 = new CarTest(100000, 300, "ZHIGULI");
        CarTest car3 = new CarTest(100000, 300, "NEXIA");

        ArrayList<CarTest> cars = new ArrayList<>();
        Collections.addAll(cars, car1, car2, car3);
        System.out.println(cars);

        ComparatorByValue comparatorByValue = new ComparatorByValue();
        ComparatorByWeight comparatorByWeight = new ComparatorByWeight();
        ComparatorByName comparatorByName = new ComparatorByName();
        CustomizedComparator<CarTest> customizedComparator = new CustomizedComparator<>(comparatorByValue, comparatorByWeight, comparatorByName);

        Collections.sort(cars, customizedComparator);
        System.out.println(cars);
    }
}

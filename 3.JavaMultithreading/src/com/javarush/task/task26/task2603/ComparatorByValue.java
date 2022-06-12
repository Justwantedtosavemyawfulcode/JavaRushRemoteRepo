package com.javarush.task.task26.task2603;

import java.util.Comparator;

public class ComparatorByValue implements Comparator<CarTest> {
    @Override
    public int compare(CarTest o1, CarTest o2) {
        return o1.value - o2.value;
    }
}

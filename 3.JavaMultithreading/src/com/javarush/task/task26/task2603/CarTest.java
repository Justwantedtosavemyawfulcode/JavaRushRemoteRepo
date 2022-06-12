package com.javarush.task.task26.task2603;

public class CarTest {
    public int value;
    public int weight;
    public String name;

    public CarTest(int value, int weight, String name) {
        this.value = value;
        this.weight = weight;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

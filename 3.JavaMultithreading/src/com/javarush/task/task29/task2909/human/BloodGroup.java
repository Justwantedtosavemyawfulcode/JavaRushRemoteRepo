package com.javarush.task.task29.task2909.human;

public class BloodGroup {
    private final int code;

    private BloodGroup(int typeOfBlood) {
        this.code = typeOfBlood;
    }

    public int getCode() {
        return code;
    }

    public static BloodGroup first() {
        return new BloodGroup(1);
    }

    public static BloodGroup second() {
        return new BloodGroup(2);
    }
    public static BloodGroup third() {
        return new BloodGroup(3);
    }
    public static BloodGroup fourth() {
        return new BloodGroup(4);
    }
}

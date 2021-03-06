package com.javarush.task.task21.task2113;

import java.util.Map;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move() {
        distance = speed * Math.random() + distance;
    }

    public void print() {
        for (double i = 0; i < Math.floor(distance); i++) {
            System.out.print(".");
        }
        System.out.println(name);
    }
}

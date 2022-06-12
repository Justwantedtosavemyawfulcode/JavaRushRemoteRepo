package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static void main(String[] args) throws InterruptedException {
        Horse one = new Horse("One", 3, 0);
        Horse two = new Horse("Two", 3, 0);
        Horse three = new Horse("Three", 3, 0);
        List<Horse> horses = new ArrayList<>();
        horses.add(one);
        horses.add(two);
        horses.add(three);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    static Hippodrome game;

    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move() {
        for (Horse horse:horses) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse:horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        double longestDistance = 0;
        Horse horseWinner = null;
        for (Horse horse:horses) {
            if (horse.distance > longestDistance) {
                longestDistance = horse.distance;
            }
        }
        for (Horse horse: horses) {
            if (horse.distance == longestDistance) {
                horseWinner = horse;
            }
        }
        return horseWinner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }
}

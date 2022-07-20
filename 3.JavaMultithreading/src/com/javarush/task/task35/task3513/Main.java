package com.javarush.task.task35.task3513;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        model.printBoard();

        model.left();
        model.printBoard();

        model.left();
        model.printBoard();

        model.left();
        model.printBoard();

        model.left();
        model.printBoard();

        model.right();
        model.printBoard();

        model.down();
        model.printBoard();

        model.up();
        model.printBoard();

    }
}

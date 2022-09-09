package com.javarush.task.task25.task2515;

public class Ufo extends BaseObject {
    private double dx = 0;
    private double dy = 0;
    private static int[][] matrix = {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0},
    };

    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }

    @Override
    public void move() {
        dx = Math.random() * 2 - 1;
        dy = Math.random() * 2 - 1;
        x = x + dx;
        y = y + dy;

        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() / 2f);
        if (Math.random() <= 0.1) {
            fire();
        }
    }

//    public void moveLeft() {
//        dx = -1;
//    }
//
//    public void moveRight() {
//        dx = 1;
//    }
//
//    public void moveUp() {
//        dy = -1;
//    }
//
//    public void moveDown() {
//        dy = 1;
//    }

    public void fire() {
        Space.game.getBombs().add(new Bomb(x, y + 3));
    }
}

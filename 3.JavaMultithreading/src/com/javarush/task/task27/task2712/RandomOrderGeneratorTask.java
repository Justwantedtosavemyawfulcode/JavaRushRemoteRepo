package com.javarush.task.task27.task2712;


import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval; // Milliseconds

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        Tablet tablet = tablets.get((int) (Math.random() * tablets.size()));
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {

        }
        tablet.createOrder();
    }
}

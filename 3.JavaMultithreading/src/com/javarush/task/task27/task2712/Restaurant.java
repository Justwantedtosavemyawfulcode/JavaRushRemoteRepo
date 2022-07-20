package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>(1000);;

    public static void main(String[] args) throws IOException {
        Cook amigoCook = new Cook("Amigo");
        amigoCook.setQueue(ORDER_QUEUE);
        Cook ricardoCook = new Cook("Ricardo");
        ricardoCook.setQueue(ORDER_QUEUE);
        amigoCook.addObserver(new Waiter());
        ricardoCook.addObserver(new Waiter());

        Thread amigoThread = new Thread(amigoCook);
        amigoThread.start();
        Thread ricardoThread = new Thread(ricardoCook);
        ricardoThread.start();

        List<Tablet> tablets = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(ORDER_QUEUE);
            tablets.add(tablet);

        }

        Thread randomOrderGeneratorTask = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        randomOrderGeneratorTask.start();
        try {
            Thread.sleep(1000);
            randomOrderGeneratorTask.interrupt();
            randomOrderGeneratorTask.join();
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}

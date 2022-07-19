package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws IOException {
        Cook amigoCook = new Cook("Amigo");
        Cook ricardoCook = new Cook("Ricardo");
        StatisticManager.getInstance().register(amigoCook);
        StatisticManager.getInstance().register(ricardoCook);
        amigoCook.addObserver(new Waiter());
        ricardoCook.addObserver(new Waiter());
        List<Tablet> tablets = new ArrayList<>(5);
        OrderManager orderManager = new OrderManager();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(orderManager);
            tablet.addObserver(orderManager);
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

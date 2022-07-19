package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(1000);

    public OrderManager() {
        Thread daemonThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                        if (!orderQueue.isEmpty()) {
                            for (Cook cook : StatisticManager.getInstance().getCooks()) {
                                if (!cook.isBusy()) {
                                    cook.startCookingOrder(orderQueue.take());
                                }
                            }
                        }
                    }
                    catch (InterruptedException e) {

                    }
                }
            }
        };
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }
}

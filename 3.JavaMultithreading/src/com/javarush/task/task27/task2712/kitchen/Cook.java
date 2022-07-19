package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable {
    private final String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        }
        catch (InterruptedException e) {

        }
        ConsoleHelper.writeMessage("Start cooking - " + order);
        Tablet tablet = order.getTablet();
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(tablet.toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    public boolean isBusy() {
        return busy;
    }
}

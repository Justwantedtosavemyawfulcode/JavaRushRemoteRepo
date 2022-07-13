package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object order) {
        ConsoleHelper.writeMessage("Start cooking - " + order);
        Tablet tablet = (Tablet) observable;
        Order orderObjectCastedToOrder = (Order) order;
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(tablet.toString(), name, orderObjectCastedToOrder.getTotalCookingTime() * 60, orderObjectCastedToOrder.getDishes()));
        setChanged();
        notifyObservers(order);
    }
}

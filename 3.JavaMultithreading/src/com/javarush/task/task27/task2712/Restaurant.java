package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

public class Restaurant {

    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(4);
        Cook amigoCook = new Cook("Amigo");
        tablet.addObserver(amigoCook);
        amigoCook.addObserver(new Waiter());
        tablet.createOrder();
//        for (Map.Entry<EventType, List<EventDataRow>> entry : StatisticManager.getInstance().statisticStorage.storage.entrySet()) {
//            for (EventDataRow eventDataRow : entry.getValue()) {
//                System.out.println(eventDataRow);
//            }
//        }
    }
}

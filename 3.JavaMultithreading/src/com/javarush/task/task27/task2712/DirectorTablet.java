package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        TreeMap<String, Long> revenueMap =  StatisticManager.getInstance().getRevenuePerDay();
        double totalSum = 0;
        for (Map.Entry<String, Long> entry : revenueMap.entrySet()) {
            double amount = entry.getValue() / 100f;
            totalSum += amount;
            ConsoleHelper.writeMessage(String.format(Locale.CANADA,"%s - %.2f", entry.getKey(), amount));
        }
        ConsoleHelper.writeMessage(String.format(Locale.CANADA, "%s - %.2f", "Total", totalSum));
    }

    public void printCookWorkloading() {

    }
    public void printActiveVideoSet() {

    }
    public void printArchivedVideoSet() {

    }
}

package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

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
        TreeMap<String, TreeMap<String, Integer>> cookingTimeByDateMap = StatisticManager.getInstance().getCookingTimeByDateAndName();

        for (Map.Entry<String, TreeMap<String, Integer>> entry : cookingTimeByDateMap.entrySet()) {
            ConsoleHelper.writeMessage(entry.getKey());
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", innerEntry.getKey(), innerEntry.getValue()));
            }
            ConsoleHelper.writeMessage("\n");
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> activeVideoSet = StatisticAdvertisementManager.getInstance().getActiveVideoList();
        activeVideoSet.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : activeVideoSet) {
            ConsoleHelper.writeMessage(String.format("%s - %d", advertisement.getName(), advertisement.getHits()));
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> nonActiveVideoSet = StatisticAdvertisementManager.getInstance().getNonActiveVideoList();
        nonActiveVideoSet.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : nonActiveVideoSet) {
            ConsoleHelper.writeMessage(String.format("%s", advertisement.getName()));
        }
    }
}

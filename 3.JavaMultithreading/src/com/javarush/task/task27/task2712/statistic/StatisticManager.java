package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static final StatisticManager statisticManager = new StatisticManager();
    private final StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return statisticManager;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public TreeMap<String, Long> getRevenuePerDay() {
        TreeMap<String, Long> revenueMap = new TreeMap<>(new Comparator<String>() {
            DateFormat f = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            @Override
            public int compare(String o1, String o2) {
                try {
                    return f.parse(o2).compareTo(f.parse(o1));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        HashMap<EventType, List<EventDataRow>> storage = statisticStorage.getStorage();
        for (EventDataRow eventDataRow : storage.get(EventType.SELECTED_VIDEOS)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String stringDate = simpleDateFormat.format(eventDataRow.getDate());
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            if (revenueMap.containsKey(stringDate)) {
                long amount = revenueMap.get(stringDate);
                amount += videoSelectedEventDataRow.getAmount();
                revenueMap.put(stringDate, amount);
            }
            else {
                revenueMap.put(stringDate, videoSelectedEventDataRow.getAmount());
            }
        }

        return revenueMap;
    }

    public TreeMap<String, TreeMap<String, Integer>> getCookingTimeByDateAndName() {
        TreeMap<String, TreeMap<String, Integer>> cookingTimeByDateMap = new TreeMap<>(new Comparator<String>() {
            DateFormat f = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            @Override
            public int compare(String o1, String o2) {
                try {
                    return f.parse(o2).compareTo(f.parse(o1));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        HashMap<EventType, List<EventDataRow>> storage = statisticStorage.getStorage();
        for (EventDataRow eventDataRow : storage.get(EventType.COOKED_ORDER)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String stringDate = simpleDateFormat.format(eventDataRow.getDate());
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;

            String currentCookName = cookedOrderEventDataRow.getCookName();
            int cookingTime = cookedOrderEventDataRow.getTime();
            if (cookingTime % 60 != 0) {
                cookingTime = cookingTime / 60 + 1;
            }
            else {
                cookingTime = cookingTime / 60;
            }

            if (cookingTimeByDateMap.containsKey(stringDate)) {
                if (cookingTimeByDateMap.get(stringDate).containsKey(currentCookName)) {
                    int tempTime = cookingTimeByDateMap.get(stringDate).get(currentCookName);
                    tempTime += cookingTime;
                    cookingTimeByDateMap.get(stringDate).put(currentCookName, tempTime);
                }
                else {
                    cookingTimeByDateMap.get(stringDate).put(currentCookName, cookingTime);
                }
            } else {
                cookingTimeByDateMap.put(stringDate, new TreeMap<String, Integer>());
                cookingTimeByDateMap.get(stringDate).put(currentCookName, cookingTime);
            }
        }
        return cookingTimeByDateMap;
    }

    private static class StatisticStorage {
        private HashMap<EventType, List<EventDataRow>> storage = new HashMap<EventType, List<EventDataRow>>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public HashMap<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}

package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static final StatisticAdvertisementManager statisticAdvertisementManager = new StatisticAdvertisementManager();
    private final AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {

    }

    public List<Advertisement> getActiveVideoList() {
        List<Advertisement> returningList = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() > 0) {
                returningList.add(advertisement);
            }
        }
        return returningList;
    }

    public List<Advertisement> getNonActiveVideoList() {
        List<Advertisement> returningList = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() == 0) {
                returningList.add(advertisement);
            }
        }
        return returningList;
    }

    public static StatisticAdvertisementManager getInstance() {
        return statisticAdvertisementManager;
    }
}

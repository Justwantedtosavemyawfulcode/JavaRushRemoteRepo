package com.javarush.task.task27.task2712.ad;

import java.util.Collections;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> storageList = storage.list();
        if (storageList.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        Collections.sort(storageList, new CustomizedComparator(new ComparatorByAmountPerOneDisplaying(), new ComparatorByAmountPerOneSecondOfShowing()));
    }
}

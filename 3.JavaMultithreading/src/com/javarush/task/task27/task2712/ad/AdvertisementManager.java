package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> videosForShowing = storage.list();
        if (videosForShowing.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        sortVideosByRevenue(videosForShowing);
        Collections.sort(videosForShowing, new CustomizedComparator(new ComparatorByAmountPerOneDisplaying(), new ComparatorByAmountPerOneSecondOfShowing()));
        for (Advertisement advertisement : videosForShowing) {
            advertisement.revalidate();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", advertisement.getName(), advertisement.getAmountPerOneDisplaying(), advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
        }
    }

    private List<Advertisement> sortVideosByRevenue(List<Advertisement> listOfVideos) {
        int timeOfCookingLeft = timeSeconds;
        List<Advertisement> sortedVideosList = new ArrayList<>(listOfVideos);
        List<Advertisement> resultList = new ArrayList<>();
        Collections.sort(sortedVideosList, new ComparatorByAmountPerOneSecondOfShowingByIncrease());
        for (Advertisement advertisement : sortedVideosList) {
            if (advertisement.getDuration() <= timeOfCookingLeft) {
                resultList.add(advertisement);
                timeOfCookingLeft -= advertisement.getDuration();
            }
        }
        return resultList;
    }
}

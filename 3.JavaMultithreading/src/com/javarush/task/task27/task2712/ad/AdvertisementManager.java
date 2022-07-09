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
        OptimalVideoListCreator optimalVideoListCreator = new OptimalVideoListCreator();
        optimalVideoListCreator.sortVideosForMaxRevenue(videosForShowing);
        videosForShowing = optimalVideoListCreator.getVideosForShowing();
        if (videosForShowing.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        Collections.sort(videosForShowing, new CustomizedComparator(new ComparatorByAmountPerOneDisplaying(), new ComparatorByAmountPerOneSecondOfShowingByIncrease()));
        for (Advertisement advertisement : videosForShowing) {
            advertisement.revalidate();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", advertisement.getName(), advertisement.getAmountPerOneDisplaying(), advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
        }
    }


    private class OptimalVideoListCreator {
        private List<Advertisement> videosForShowing;
        private long bestTotalPrice;

        private long calculateTotalPrice(List<Advertisement> videos) {
            int returnedResult = 0;
            for (Advertisement advertisement : videos) {
                returnedResult += advertisement.getAmountPerOneDisplaying();
            }
            return returnedResult;
        }

        private int calculateLength(List<Advertisement> videos) {
            int returnedResult = 0;
            for (Advertisement advertisement : videos) {
                returnedResult += advertisement.getDuration();
            }
            return returnedResult;
        }

        private void checkVideoList(List<Advertisement> videos) {
            if (videosForShowing == null) {
                if (calculateLength(videos) <= timeSeconds) {
                    videosForShowing = videos;
                }
            }
            else {
                if ((calculateLength(videos) <= timeSeconds) && (calculateTotalPrice(videos) >= bestTotalPrice)) {
                    bestTotalPrice = calculateTotalPrice(videos);
                    videosForShowing = videos;
                }
            }
        }

        private void sortVideosForMaxRevenue(List<Advertisement> videos) {
            if (videos.size() > 0) {
                checkVideoList(videos);
            }
            for (int i = 0; i < videos.size(); i++) {
                List<Advertisement> newList = new ArrayList<>(videos);
                newList.remove(i);
                sortVideosForMaxRevenue(newList);
            }
        }

        public List<Advertisement> getVideosForShowing() {
            return videosForShowing;
        }
    }
}

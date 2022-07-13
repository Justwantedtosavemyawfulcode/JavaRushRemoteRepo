package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

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
        optimalVideoListCreator.removeAllVideosWithoutHitsAndSortForMaxRevenue(videosForShowing);
        videosForShowing = optimalVideoListCreator.getVideosForShowing();
        if (videosForShowing.isEmpty()) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }
        Collections.sort(videosForShowing, new CustomizedComparator(new ComparatorByAmountPerOneDisplaying(), new ComparatorByAmountPerOneSecondOfShowingByIncrease()));
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(videosForShowing, optimalVideoListCreator.bestTotalPrice, (int) optimalVideoListCreator.maxSumTime));
        for (Advertisement advertisement : videosForShowing) {
            advertisement.revalidate();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", advertisement.getName(), advertisement.getAmountPerOneDisplaying(), advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
        }
    }


    private class OptimalVideoListCreator {
        private List<Advertisement> videosForShowing = new ArrayList<>();
        private long bestTotalPrice = 0;
        private long maxSumTime = 0;
        private int minSizeOfList = 0;

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
            int timeOfCurrentList = calculateLength(videos);
            long priceOfCurrentList = calculateTotalPrice(videos);
            if (videosForShowing.isEmpty()) {
                if (timeOfCurrentList <= timeSeconds) {
                    bestTotalPrice = priceOfCurrentList;
                    maxSumTime = timeOfCurrentList;
                    minSizeOfList = videos.size();
                    videosForShowing = videos;
                }
            }
            else {
                if (timeOfCurrentList <= timeSeconds && priceOfCurrentList >= bestTotalPrice) {
                    if (timeOfCurrentList > maxSumTime) {
                        bestTotalPrice = priceOfCurrentList;
                        maxSumTime = timeOfCurrentList;
                        minSizeOfList = videos.size();
                        videosForShowing = videos;
                    }
                    if (priceOfCurrentList == bestTotalPrice && timeOfCurrentList == maxSumTime && videos.size() < minSizeOfList) {
                        bestTotalPrice = priceOfCurrentList;
                        maxSumTime = timeOfCurrentList;
                        minSizeOfList = videos.size();
                        videosForShowing = videos;
                    }
                }
            }
        }

        public void removeAllVideosWithoutHitsAndSortForMaxRevenue(List<Advertisement> videos) {
            List<Advertisement> videosToDeletion = new ArrayList<>();
            for (Advertisement advertisement : videos) {
                if (advertisement.getHits() == 0) {
                    videosToDeletion.add(advertisement);
                }
            }
            videos.removeAll(videosToDeletion);
            sortVideosForMaxRevenue(videos);
        }

        private void sortVideosForMaxRevenue(List<Advertisement> videos) {
            if (videos.size() > 0) {
                checkVideoList(videos);
            }
            for (int i = 0; i < videos.size(); i++) {
                List<Advertisement> newList = new ArrayList<>(videos);
                newList.remove(i);
                if (calculateTotalPrice(newList) >= bestTotalPrice) {
                    sortVideosForMaxRevenue(newList);
                }
            }
        }

        public List<Advertisement> getVideosForShowing() {
            return videosForShowing;
        }
    }
}

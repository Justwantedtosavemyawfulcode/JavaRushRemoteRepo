package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static final AdvertisementStorage advertisementStorage = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
//        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
//        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
//        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min

//        videos.add(new Advertisement(someContent, "3video", 10, 1, 15* 60));
//        videos.add(new Advertisement(someContent, "2video", 10, 1, 15* 60));
//        videos.add(new Advertisement(someContent, "1video", 10, 1, 30*60));
//        videos.add(new Advertisement(someContent, "4video", 10, 1, 1*60));

        videos.add(new Advertisement(someContent, "Video 001", 555, 11, 5 * 60));   // 5 min
        videos.add(new Advertisement(someContent, "Video 002", 700, 10, 7 * 60));   // 7 min
        videos.add(new Advertisement(someContent, "Video 003", 560, 11, 5 * 60));   // 5 min
        videos.add(new Advertisement(someContent, "Video 004", 1500, 10, 15 * 60)); // 15 min
        videos.add(new Advertisement(someContent, "Video 005", 700, 10, 7 * 60));   // 7 min
        videos.add(new Advertisement(someContent, "Video 006", 100, 10, 1 * 60));   // 1 min

    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public static AdvertisementStorage getInstance() {
        return advertisementStorage;
    }
}

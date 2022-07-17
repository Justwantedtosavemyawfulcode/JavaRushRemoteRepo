package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvertisementStorage {
    private static final AdvertisementStorage advertisementStorage = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object videoContent = new Object();

//        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
//        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
//        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min

//        videos.add(new Advertisement(someContent, "3video", 10, 1, 15* 60));
//        videos.add(new Advertisement(someContent, "2video", 10, 1, 15* 60));
//        videos.add(new Advertisement(someContent, "1video", 10, 1, 30*60));
//        videos.add(new Advertisement(someContent, "4video", 10, 1, 1*60));

//        videos.add(new Advertisement(someContent, "DD", 555, 11, 5 * 60));   // 5 min
//        videos.add(new Advertisement(someContent, "B", 700, 0, 7 * 60));   // 7 min
//        videos.add(new Advertisement(someContent, "CC", 560, 11, 5 * 60));   // 5 min
//        videos.add(new Advertisement(someContent, "четвертое видео", 1500, 10, 15 * 60)); // 15 min
//        videos.add(new Advertisement(someContent, "a", 700, 10, 7 * 60));   // 7 min
//        videos.add(new Advertisement(someContent, "EFG", 100, 0, 1 * 60));   // 1 min
        Advertisement[] ads = {
                new Advertisement(videoContent, "Video 001",
                        500, 10, 5 * 60),   // 5 min
                new Advertisement(videoContent, "Video 002",
                        700, 10, 7 * 60),   // 7 min
                new Advertisement(videoContent, "Video 003",
                        500, 10, 5 * 60),   // 5 min
                new Advertisement(videoContent, "Video 004",
                        1500, 10, 15 * 60), // 15 min
                new Advertisement(videoContent, "Video 005",
                        700, 10, 7 * 60),   // 7 min
                new Advertisement(videoContent, "Video 006",
                        100, 10, 1 * 60),   // 1 min
                new Advertisement(videoContent, "Video 007",
                        500, 10, 5 * 60)    // 5 min
        };
        videos.addAll(Arrays.asList(ads));

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

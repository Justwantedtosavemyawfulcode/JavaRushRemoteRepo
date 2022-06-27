package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;

public class ComparatorByAmountPerOneSecondOfShowing implements Comparator<Advertisement> {

    @Override
    public int compare(Advertisement o1, Advertisement o2) {
        return (int) (o1.getAmountPerOneDisplaying() / o1.getDuration() - o2.getAmountPerOneDisplaying() / o2.getDuration());
    }
}

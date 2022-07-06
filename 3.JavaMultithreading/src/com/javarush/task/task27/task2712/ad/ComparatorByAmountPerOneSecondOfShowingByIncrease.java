package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;

public class ComparatorByAmountPerOneSecondOfShowingByIncrease implements Comparator<Advertisement> {

    @Override
    public int compare(Advertisement o1, Advertisement o2) {
        return (int) (o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration() - o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration());
    }
}
package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;

public class CustomizedComparator implements Comparator<Advertisement> {
    private Comparator<Advertisement>[] comparators;

    public CustomizedComparator(Comparator<Advertisement>... vararg) {
        comparators = vararg;
    }


    @Override
    public int compare(Advertisement o1, Advertisement o2) {
        for (Comparator<Advertisement> comparator : comparators) {
            int resultOfCompare = comparator.compare(o1, o2);
            if (resultOfCompare != 0) {
                return resultOfCompare;
            }
        }
        return 0;
    }
}

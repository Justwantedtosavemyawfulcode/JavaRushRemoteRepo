package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH (25),
    STEAK (30),
    SOUP (15),
    JUICE (5),
    WATER (3);

    private int duration;

    public int getDuration() {
        return duration; // Minutes
    }

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Dish dish : Dish.values()) {
            stringBuilder.append(dish).append(", ");
        }
        String returningString = stringBuilder.toString().trim();
        returningString = returningString.substring(0, returningString.length() - 1);
        return returningString;
    }
}

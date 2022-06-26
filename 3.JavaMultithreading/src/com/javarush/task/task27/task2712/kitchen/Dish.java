package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

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

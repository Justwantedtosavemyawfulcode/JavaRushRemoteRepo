package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        int returningTotalTime = 0;
        for (Dish dish : dishes) {
            returningTotalTime += dish.getDuration();
        }
        return returningTotalTime;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.size() == 0) {
            return "";
        }
        else {
            StringBuilder stringBuilder = new StringBuilder("Your order: [");
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (Dish dish : dishes) {
                stringJoiner.add(dish.toString());
            }
            return stringBuilder.append(stringJoiner.toString())
                    .append("] of ")
                    .append(tablet.toString())
                    .append(", cooking time " + getTotalCookingTime() + "min").toString();
        }
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }
}

package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
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
            return stringBuilder.append(stringJoiner.toString()).append("] of ").append(tablet.toString()).toString();
        }
    }
}

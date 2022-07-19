package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        dishes = new ArrayList<>();
        for (int i = 0; i < Math.random() * 10; i++) {
            Dish[] dishValuesArray = Dish.values();
            dishes.add(dishValuesArray[(int) (Math.random() * dishValuesArray.length - 1)]);
        }
    }
}

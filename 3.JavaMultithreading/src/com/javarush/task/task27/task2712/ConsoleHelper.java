package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> listOfDishes = new ArrayList<>();

        while (true) {
            System.out.println(Dish.allDishesToString());
            System.out.println("Введите название блюда в формате представленном выше, либо \"exit\" для выхода:"); // Возможно надо вынести из лупы
            String enteredMessage = readString();
            if (enteredMessage.equals("exit")) break;

            try {
                Dish selectedDish = Dish.valueOf(enteredMessage);
                listOfDishes.add(selectedDish);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Такого блюда нет, введите другое:");
            }
        }
        return listOfDishes;
    }

}

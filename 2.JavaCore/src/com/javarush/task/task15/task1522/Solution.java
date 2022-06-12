package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {

        }

    }
    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        if (input.equals(Planet.EARTH)) {
            thePlanet = Earth.getInstance();

        }
        else if (input.equals(Planet.MOON)) {
            thePlanet = Moon.getInstance();

        }
        else if (input.equals(Planet.SUN)) {
            thePlanet = Sun.getInstance();

        }
        else {
            thePlanet = null;
        }
        // implement step #5 here - реализуйте задание №5 тут
    }
}

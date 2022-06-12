package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.MOLDOVA;
import static com.javarush.task.task14.task1408.Country.UKRAINE;

public class UkrainianHen extends Hen{

    @Override
    public int getCountOfEggsPerMonth() {
        return 4;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

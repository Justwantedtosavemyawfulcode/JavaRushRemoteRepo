package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.BELARUS;
import static com.javarush.task.task14.task1408.Country.MOLDOVA;

public class BelarusianHen extends Hen{

    @Override
    public int getCountOfEggsPerMonth() {
        return 16;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

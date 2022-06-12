package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.MOLDOVA;

public class MoldovanHen extends Hen{

    @Override
    public int getCountOfEggsPerMonth() {
        return 8;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    final int counts = 667;
    @Override
    public int getCarsCount() {
        return counts;
    }
}


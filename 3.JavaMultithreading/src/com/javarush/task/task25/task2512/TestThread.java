package com.javarush.task.task25.task2512;

public class TestThread extends Thread {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
            } catch (Exception e) {
                this.getUncaughtExceptionHandler().uncaughtException(this, e);
            }
        }
    }
}

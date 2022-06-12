package com.javarush.task.task25.task2505;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            Thread.sleep(500);
            t.getName();

        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

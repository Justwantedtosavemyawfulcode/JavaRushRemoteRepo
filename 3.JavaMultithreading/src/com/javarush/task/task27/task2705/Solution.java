package com.javarush.task.task27.task2705;

/* 
Второй вариант deadlock
*/

public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
            System.out.println("doingFirst");
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
                System.out.println("doingSecond");
            }
        }
    }

    private void doSomething() {
    }

    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new Solution().secondMethod();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new Solution().firstMethod();
                }
            }).start();
        }
    }
}

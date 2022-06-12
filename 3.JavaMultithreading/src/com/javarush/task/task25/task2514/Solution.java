package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/

public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        YieldRunnable test1 = new YieldRunnable(1);
        YieldRunnable test2 = new YieldRunnable(2);
        YieldRunnable test3 = new YieldRunnable(3);
//        YieldRunnable test4 = new YieldRunnable(4);

        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);
//        Thread thread3 = new Thread(test3);
//        Thread thread4 = new Thread(test4);

        thread1.start();
//        thread1.join();
        thread2.start();
//        thread2.join();
//        thread3.start();
//        thread3.join();
//        thread4.start();
    }
}

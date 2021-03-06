package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/


public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj2) {
            synchronized (obj1) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public boolean testMethod(Object o1, Object o2) throws InterruptedException {
        synchronized (o1) {
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {

            }
            synchronized (o2) {
                return false;
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution.testMethod(o1, o2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        if (thread1.getState() == Thread.State.BLOCKED) {
            thread1.stop();
            thread2.stop();
            return false;
        }
        else return true;

    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}

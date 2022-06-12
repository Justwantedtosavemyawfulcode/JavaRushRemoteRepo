package com.javarush.task.task25.task2512;

import java.util.*;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {
    ArrayList<Throwable> causes = new ArrayList<>();

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e != null) {
            causes.add(e);
            uncaughtException(t, e.getCause());
            t.interrupt();
        }
        else {
            Collections.reverse(causes);
            for (Throwable throwable : causes) {
                System.out.println(throwable);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        TestThread thread = new TestThread();
        thread.setUncaughtExceptionHandler(solution);
        thread.start();

    }

}

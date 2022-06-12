package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

import javax.crypto.spec.PSource;
import java.util.Date;

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                while (numSeconds > 0) {
                    System.out.println(numSeconds);
                    numSeconds--;
                    Thread.sleep(1000);
                }
                System.out.println("Марш!");
            }
            catch (InterruptedException e) {
                System.out.println("Прервано!");
            }
            //add your code here - добавь код тут
        }
    }
}

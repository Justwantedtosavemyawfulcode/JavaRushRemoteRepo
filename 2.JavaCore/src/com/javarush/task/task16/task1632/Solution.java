package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new InfiniteLoopThread());
        threads.add(new InterruptedThread());
        threads.add(new HurrayThread());
        threads.add(new MessageThread());
        threads.add(new NWordgoesBrrr());
    }

    public static void main(String[] args) {

    }

    public static class InfiniteLoopThread extends Thread {
        public void run() {
            while (true) {

            }
        }
    }

    public static class InterruptedThread extends Thread {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

    }

    public static class HurrayThread extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e) {

            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        boolean warningFlag = false;
        @Override
        public void showWarning() {
            warningFlag = true;
        }

        public void run() {
            while (!(warningFlag)) {

            }
        }
    }

    public static class NWordgoesBrrr extends Thread {
        int sum = 0;
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String input = bufferedReader.readLine();
                    while (!(input.equals("N"))) {
                        sum += Integer.parseInt(input);
                        input = bufferedReader.readLine();
                    }
                    System.out.println(sum);
            }
            catch (IOException e) {

            }
        }
    }
}
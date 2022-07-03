package com.javarush.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    TransferQueue<ShareItem> queue = new LinkedTransferQueue<>();

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {

        }
        while (!Thread.currentThread().isInterrupted()) {
            try {
                ShareItem shareItem = queue.take();
                System.out.format("Processing %s\n", shareItem);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

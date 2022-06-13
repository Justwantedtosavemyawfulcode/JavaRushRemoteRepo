package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.util.Random;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public class BotSocketThread extends SocketThread {


    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
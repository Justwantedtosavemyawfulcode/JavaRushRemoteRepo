package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(": ")) return;
//            String[] stringsOfMessage = message.split(": ");
//            String name = stringsOfMessage[0];
//            String request = stringsOfMessage[1];
            String name = message.substring(0, message.indexOf(":"));
            String request = message.substring(message.indexOf(":") + 1).trim();
            if (request.equals("дата")) {
                sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat("d.MM.YYYY").format(new GregorianCalendar().getTime()));
            }
            if (request.equals("день")) {
                sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat("d").format(new GregorianCalendar().getTime()));
            }
            if (request.equals("месяц")) {
                sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat("MMMM").format(new GregorianCalendar().getTime()));
            }
            if (request.equals("год")) {
                sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat("YYYY").format(new GregorianCalendar().getTime()));
            }
            if (request.equals("время")) {
                sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat("H:mm:ss").format(new GregorianCalendar().getTime()));
            }
            if (request.equals("час")) {
                sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat("H").format(new GregorianCalendar().getTime()));
            }
            if (request.equals("минуты")) {
                sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat("m").format(new GregorianCalendar().getTime()));
            }
            if (request.equals("секунды")) {
                sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat("s").format(new GregorianCalendar().getTime()));
            }
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}

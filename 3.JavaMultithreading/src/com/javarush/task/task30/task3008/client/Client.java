package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Закрытие программы...");
            }
            if (clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено.\n" +
                        "Для выхода наберите команду 'exit'.");
            }
            else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

            while (clientConnected) {
                try {
                    String text = ConsoleHelper.readString();
                    if (text.equals("exit")) break;
                    if (shouldSendTextFromConsole()) sendTextMessage(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected String getServerAddress() throws IOException {
        ConsoleHelper.writeMessage("Введите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String message) {
        try {
            connection.send(new Message(MessageType.TEXT, message));
        }
        catch (IOException e) {
            ConsoleHelper.writeMessage("При отправке сообщения возникла ошибка.");
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread {

        public void run() {
            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                }
                else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                }
                else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                }
                else throw new IOException("Unexpected MessageType");
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String username) {
            ConsoleHelper.writeMessage(username+ " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String username) {
            ConsoleHelper.writeMessage(username + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }
                else {
                    if (message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                        break;
                    } else {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}

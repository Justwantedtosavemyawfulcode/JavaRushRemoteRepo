package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            }
            catch (IOException e) {
                System.out.println("Невозможно отправить сообщение");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            ConsoleHelper.writeMessage("Установленно соединение с " + socket.getRemoteSocketAddress());
            String newClientName = "";
            try {
                Connection connection = new Connection(socket);
                newClientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClientName));
                notifyUsers(connection, newClientName);
                serverMainLoop(connection, newClientName);
                connection.close();
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
                try {
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            connectionMap.remove(newClientName);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClientName));
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String returningName;
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message nameMessage = connection.receive();
            if (nameMessage.getType() == MessageType.USER_NAME) {
                returningName = nameMessage.getData();
                if (returningName != null && (!(returningName.equals("")))) {
                    if (!(connectionMap.containsKey(returningName))) {
                        connectionMap.put(returningName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return returningName;
                    }
                    else return serverHandshake(connection);
                }
                else return serverHandshake(connection);
            }
            else return serverHandshake(connection);
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData())));
                } else ConsoleHelper.writeMessage("Ошибка! Данные не являются текстом!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Установите порт для доступа к серверу:");
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        System.out.println("Сервер запущен");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
                continue;
            }
            catch (Exception e) {
                serverSocket.close();
                e.printStackTrace();
                break;
            }
        }
    }
}

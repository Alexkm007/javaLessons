package com.javarush.task.task30.task3008;

import com.sun.javafx.iio.ios.IosImageLoaderFactory;

import java.io.IOException;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap();

    public static void main(String[] args) throws IOException {

        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server is ready");

            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }

    }

    public static void sendBroadcastMessage(Message message) throws IOException {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            Connection connection = entry.getValue();
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message ansver = connection.receive();
                String name = ansver.getData();
                if (ansver.getType() == MessageType.USER_NAME) {
                    if (name.length() != 0 && !connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    }
                }

            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
              //  try {
                    Message message = connection.receive();
                    if (message.getType() != MessageType.TEXT) {
                        ConsoleHelper.writeMessage("Неверный тип сообщения");
                        continue;
                    }
                    String text = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));

              //  } catch (IOException e) {
               //     ConsoleHelper.writeMessage(e.getMessage());
               // }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            try {
                for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                    String name = entry.getKey();
                    if (!name.equals(userName)) {
                        connection.send(new Message(MessageType.USER_ADDED, name));
                    }
                }
            } catch (IOException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        }
    }


}

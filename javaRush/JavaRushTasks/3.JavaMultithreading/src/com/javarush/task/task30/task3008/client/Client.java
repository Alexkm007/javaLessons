package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected;

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() throws IOException {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text) throws IOException {
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e){
            ConsoleHelper.writeMessage(e.getMessage());
            clientConnected = false;
        }

    }

    public  void run() throws IOException {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try {
                wait();
                if(clientConnected){
                    ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
                } else {
                    ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
                }

                while (clientConnected){
                    String s  = ConsoleHelper.readString();
                    if(s.equals("exit")){
                        break;
                    }
                    if(shouldSendTextFromConsole()){
                    connection.send(new Message(MessageType.TEXT,s));}
                }
            } catch (InterruptedException e) {
               ConsoleHelper.writeMessage(e.getMessage());
               return;
            }
        }

    }


    public class SocketThread extends Thread {

    }
}

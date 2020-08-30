package com.javarush.task.task30.task3008.client;

import java.io.IOException;

public class BotClient extends Client{

    public static void main(String[] args) throws IOException {
        BotClient botClient = new BotClient();
        botClient.run();
    }

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
        int x = (int) (Math.random()*100);
        return "date_bot_" + x;
    }

    public class BotSocketThread extends SocketThread{


    }

}

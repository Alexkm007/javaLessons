package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

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
        int x = (int) (Math.random() * 100);
        return "date_bot_" + x;
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, " +
                    "день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) throws IOException {
            ConsoleHelper.writeMessage(message);
            String[] s = message.split(":");
            if (s.length < 2) {
                return;
            }
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat;
            String text = "Информация для "+s[0] +": ";
            String datatext = null;
            if(s[1].trim().equals("дата")){
             dateFormat = new SimpleDateFormat("d.MM.YYYY");
                datatext = dateFormat.format(date);
            }
            if(s[1].trim().equals("день")){
                dateFormat = new SimpleDateFormat("d");
                datatext = dateFormat.format(date);
            }
            if(s[1].trim().equals("месяц")){
                dateFormat = new SimpleDateFormat("MMMM");
                datatext = dateFormat.format(date);
            }
            if(s[1].trim().equals("год")){
                dateFormat = new SimpleDateFormat("YYYY");
                datatext = dateFormat.format(date);
            }
            if(s[1].trim().equals("время")){
                dateFormat = new SimpleDateFormat("H:mm:ss");
                datatext = dateFormat.format(date);
            }
            if(s[1].trim().equals("час")){
                dateFormat = new SimpleDateFormat("H");
                datatext = dateFormat.format(date);
            }
            if(s[1].trim().equals("минуты")){
                dateFormat = new SimpleDateFormat("m");
                datatext = dateFormat.format(date);
            }
            if(s[1].trim().equals("секунды")){
                dateFormat = new SimpleDateFormat("s");
                datatext = dateFormat.format(date);
            }

            if(datatext!=null){
                sendTextMessage(text+datatext);
            }

        }
    }

}

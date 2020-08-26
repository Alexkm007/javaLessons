package com.javarush.task.task25.task2507;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* 
Работать в поте лица!
*/
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;


    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        try {
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
        }

    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        if(isInterrupted()){
                            return;
                        }
                    }
                }
            }
        } catch (IOException ignored) {
            if(isInterrupted()){
                return;
            }
        }
    }

    public static void main(String[] args) {
    }
}

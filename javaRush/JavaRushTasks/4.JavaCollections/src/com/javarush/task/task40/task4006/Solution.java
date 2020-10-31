package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) throws IOException {
        String server  = url.getHost();
        String path  = url.getPath();

        Socket s = new Socket(server, 80);
        PrintWriter wtr = new PrintWriter(s.getOutputStream());
        wtr.println("GET "+path+" HTTP/1.1");
        wtr.println("Host: "+server);
        wtr.println("");
        wtr.flush();

        BufferedReader bufRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String outStr;

        //Prints each line of the response
        while((outStr = bufRead.readLine()) != null){
            System.out.println(outStr);
        }

        //Closes out buffer and writer
        bufRead.close();
        wtr.close();
        s.close();
    }
}
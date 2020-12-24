package testNetExchenge.url;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestHttpUrlConnection {

    public static void main(String[] args) throws IOException {

        URL ya = new URL("https://yandex.ru/");
        HttpURLConnection con = (HttpURLConnection)ya.openConnection();
        System.out.println("код ответа " + con.getResponseCode());

    }

}

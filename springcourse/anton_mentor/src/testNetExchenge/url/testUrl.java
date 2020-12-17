package testNetExchenge.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class testUrl {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.ru/");
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
        String temp = "";

        while ((temp = bf.readLine()) != null){
            System.out.println(temp);
        }
        bf.close();
    }
}

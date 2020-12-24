package testNetExchenge.testSoket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("ya.ru");
        System.out.println(" Хост " + ia.getHostName());
        System.out.println(" ip адрес " + ia.getHostAddress());
    }
}

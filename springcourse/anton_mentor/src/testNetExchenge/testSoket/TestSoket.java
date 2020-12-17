package testNetExchenge.testSoket;

import java.io.*;
import java.net.Socket;

public class TestSoket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("ito.edu.ru",80);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        String temp = "";
        pw.print("GET / HTTP/1.1\r\n");
        pw.print("Host: ito.edu.ru\r\n\r\n");
        pw.flush();
        while((temp = br.readLine()) != null){
            System.out.println(temp);
        }
        pw.close();
        br.close();
        socket.close();

    }
}

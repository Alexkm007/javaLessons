package homework9.jsonhw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        Massege massege = new Massege("Alex","Anton","Hello Word",new Date());

        Server server = new Server();
        server.start();

        Socket client = new Socket("localHost",9999);
        OutputStream os = client.getOutputStream();
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(os));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Massege.class,new MassegeJsonWorker());
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String rezult = gson.toJson(massege);

        bf.write(rezult);
        bf.flush();
        bf.close();

        System.out.println("Отправлено сообщение: ");
        System.out.println(rezult);

    }

    public static class Server extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                ServerSocket server = new ServerSocket(9999);
                Socket socket = server.accept();
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null){
                    sb.append(line);
                }
                System.out.println("Получено сообщение: ");
                System.out.println(sb.toString());

                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(Massege.class,new MassegeJsonWorker());
                gsonBuilder.setPrettyPrinting();
                Gson gson = gsonBuilder.create();
                Massege massege = gson.fromJson(sb.toString(),Massege.class);

                System.out.println("После конвертации из Json: ");
                System.out.println(massege);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

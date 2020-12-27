package jsontest.uniSerial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Train train  = new Train("London","Paris", new Date());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Train.class,new JsonTrainWorker());
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String result = gson.toJson(train);
        System.out.println(result);
        Train trainOne = gson.fromJson(result,Train.class);
        System.out.println(trainOne);
    }
}

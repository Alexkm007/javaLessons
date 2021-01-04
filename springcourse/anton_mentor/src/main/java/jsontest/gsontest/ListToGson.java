package jsontest.gsontest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ListToGson {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(3);

        Gson gson = new Gson();
        String result = gson.toJson(list);
        System.out.println(result);

        ArrayList<Integer> listTwo = gson.fromJson(result,
                new TypeToken<ArrayList<Integer>>(){}.getType());
        System.out.println(listTwo);

    }
}

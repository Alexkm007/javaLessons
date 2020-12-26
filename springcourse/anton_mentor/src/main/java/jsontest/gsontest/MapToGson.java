package jsontest.gsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MapToGson {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(map);
        Type type = new TypeToken<Map<Integer,String>>(){}.getType();
        Map<Integer,String> readMap = gson.fromJson(result,type);
        System.out.println(readMap);

    }


}

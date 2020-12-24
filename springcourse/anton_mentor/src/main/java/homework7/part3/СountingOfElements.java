package homework7.part3;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class СountingOfElements {
    private int[] arrey;
    private Map<Integer,Integer> map = new TreeMap<>();

    public СountingOfElements() {
    }

    public void counting() {
        for(int i:arrey){
            if(map.get(i)!=null){
               int count = map.get(i)+1;
               map.put(i,count);
            } else map.put(i,1);
        }

        System.out.println(map);
    }

    public void generateArrey(int size){
        this.arrey = new int[size];
        Random random = new Random();
        for(int i = 0; i<this.arrey.length;i=i+1){
            this.arrey[i] =  random.nextInt(10);
        }

    }

}

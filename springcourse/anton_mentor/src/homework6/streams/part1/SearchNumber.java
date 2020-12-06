package homework6.streams.part1;

import java.util.Random;

public class SearchNumber {

    private int[] arrrey;

    public SearchNumber(int[] arrrey) {
        this.arrrey = arrrey;
    }

    public void generateArrey(int i){
        arrrey = new int[i];
        Random random = new Random();
        for(int j = 0; j<i;j=j+1){
            if(random.nextBoolean()) {
                arrrey[j] = random.nextInt();
            }else arrrey[j] = -1*random.nextInt();
        }
    }

}

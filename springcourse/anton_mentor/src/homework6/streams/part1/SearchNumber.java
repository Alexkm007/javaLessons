package homework6.streams.part1;

import java.util.*;

public class SearchNumber {

    private int[] arrey;

    public SearchNumber() {
    }

    public void generateArrey(int i){
        arrey = new int[i];
        Random random = new Random();
        for(int j = 0; j<i;j=j+1){
            if(random.nextBoolean()) {
                arrey[j] = random.nextInt(100);
            }else arrey[j] = -1*random.nextInt(100);
        }
    }

    private List<Integer> toList(){
        List<Integer> intList = new ArrayList<Integer>(arrey.length);
        for (int i : arrey)
        {
            intList.add(i);
        }
        return intList;
    }

    public int nearestToZero(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return 1;
                } else if(Math.abs(o1) < Math.abs(o2)) return -1;
                return 0;
            }
        };
        List<Integer> list = toList();
        return list.stream().min(comparator::compare).get();
    }

    public void printArrey(){
        System.out.println(toList());
    }

}

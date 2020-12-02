package homework6.part1;

import java.util.*;

public class CollectLetters {

    private ReturningData dataProvider;

    public CollectLetters() {
    }

    public CollectLetters(ReturningData dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void setDataProvider(ReturningData dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void collect() {

        TreeMap<Character, Integer> tm = new TreeMap<>();
        char[] characters = dataProvider.returnData().toLowerCase().toCharArray();
        for (char ch : characters) {
            Integer i = tm.get(ch);
            if (i != null) {
                i = i + 1;
                tm.put(ch, i);
            } else {
                tm.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : tm.entrySet()) {
            System.out.println(String.format("Всего букв в тексте: %d " +
                            " буква %s встречается %d, что составляет сотавляет %.2f%% \r"
                    , characters.length,entry.getKey(),entry.getValue(), entry.getValue()/(float)characters.length*100F));
        }


    }

}




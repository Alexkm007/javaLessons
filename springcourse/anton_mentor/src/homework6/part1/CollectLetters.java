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


        char[] characters = dataProvider.returnData().toLowerCase().toCharArray();

        Set<Character> set = new TreeSet<>();
        for (char char_ : characters) {
            set.add(char_);
        }

        for (char ch : set) {
            int count = 0;
            for (char char_ : characters) {
                if (char_ == ch) count = count + 1;
            }
            System.out.printf("Всего букв в тексте: %d " +
                            " буква %s встречается %d, что составляет сотавляет %.2f%% \r%n"
                    , characters.length, ch, count, count / (float) characters.length * 100F);
        }
    }

}




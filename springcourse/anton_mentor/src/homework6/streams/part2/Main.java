package homework6.streams.part2;

public class Main {
    public static void main(String[] args) {
        MaxInList max = new MaxInList();
        max.setDataProvider(new DataFromFile("/home/aleksei/test/numbers.txt"));
        System.out.println(String.format("Максимальные число в файле: %.2f",max.returnMax()));
    }
}

package homework6.part1;

public class Main {
    public static void main(String[] args) {
        ReturningData rd = new ReadFile("/home/aleksei/test/enText.txt");
        CollectLetters cl = new CollectLetters(rd);
        cl.collect();
    }
}

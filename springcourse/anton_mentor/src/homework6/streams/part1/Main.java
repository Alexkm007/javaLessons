package homework6.streams.part1;

public class Main {
    public static void main(String[] args) {
        SearchNumber searchNumber = new SearchNumber();
        searchNumber.generateArrey(5);
        searchNumber.printArrey();
        System.out.println(searchNumber.nearestToZero());
    }
}

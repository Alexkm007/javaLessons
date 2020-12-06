package homework6.streams.part1;

public class Main {
    public static void main(String[] args) {
        SearchNumber searchNumber = new SearchNumber();
        //searchNumber.generateArrey(10);
        int[] arrey = new int[]{-5,20,14,5,22,-16};
        searchNumber.setArrey(arrey);
        searchNumber.printArrey();
        System.out.println(searchNumber.nearestToZero());
    }
}

package generics;

public class Main {
    public static void main(String[] args) {
        NameAnima nameAnima = new NameAnima(new Cat("Murka"));
        nameAnima.getName(new Berd("Sherhan"));
    }
}

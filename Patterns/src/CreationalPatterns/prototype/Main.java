package CreationalPatterns.prototype;

public class Main {
    public static void main(String[] args) {
        Person person1  = new Person("Alex",38);
        Person person2 = person1.copy();
        System.out.println(person1);
        System.out.println(person2);
    }
}

package generics;

public class Animal {

    private String Name;

    public Animal(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Name='" + Name + '\'' +
                '}';
    }
}

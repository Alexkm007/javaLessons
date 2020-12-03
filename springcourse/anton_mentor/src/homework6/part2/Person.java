package homework6.part2;

public class Person implements Cloneable{
    private String Name;

    public Person() {
    }

    public Person(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package CreationalPatterns.prototype;

public class Person implements Copy<Person>{

    public Person(String name, int age) {
        this.name = name;
        Age = age;
    }

    String name;
    int Age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public Person copy() {
        Person person = new Person(getName(),getAge());
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                '}';
    }
}

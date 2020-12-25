package jsontest;

public class Strudent {

    String name;
    String lastName;
    int age;
    String groupName;

    public Strudent(String name, String lastName, int age, String groupName) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.groupName = groupName;
    }

    public Strudent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Strudent{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}

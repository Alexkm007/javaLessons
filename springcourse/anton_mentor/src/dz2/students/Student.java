package dz2.students;

public class Student extends Person {

    public Student() {
    }

    public Student(String name, int age, Sex sex) {
        super(name, age, sex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", sex=" + super.getSex() +
                '}';
    }
}

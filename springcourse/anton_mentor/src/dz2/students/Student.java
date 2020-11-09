package dz2.students;

public class Student extends Person {

    private String faculty;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Student() {
    }

    public Student(String name, int age, Sex sex,String faculty) {
        super(name, age, sex);
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", sex=" + super.getSex() +
                ", faculty=" + this.faculty +
                '}';
    }
}

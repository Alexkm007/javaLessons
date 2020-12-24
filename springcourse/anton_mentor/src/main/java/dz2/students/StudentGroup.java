package dz2.students;

import dz2.students.sort.Sortby;
import dz2.students.sort.SortingType;
import dz2.students.sort.UpDown;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentGroup implements Voenkom, Serializable{
    private Student[] members = new Student[10];

    public StudentGroup() {
    }

    public Student[] getMembers() {
        return members;
    }

    public void setMembers(Student[] members) {
        this.members = members;
    }

    public void add(Student student) throws MembersOutOfSize {
        if (studentInGroup(student)) {
            return;
        }
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) {
                this.members[i] = student;
                return;
            }
        }
        throw new MembersOutOfSize();
    }

    public int getMembersLength() {
        return this.members.length;
    }

    public Student searchStudent(String name) {
        Optional<Student> student = Arrays.asList(this.members).stream()
                .filter(member -> member != null && member.getName().equalsIgnoreCase(name))
                .findFirst();
        if (student.isPresent()) return student.get();
        return null;
    }

    public void remove(Student student) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] != null && this.members[i].equals(student)) {
                this.members[i] = null;
                break;
            }
        }
    }

    private boolean studentInGroup(Student student) {
        return Arrays.asList(this.members).contains(student);
    }

    private int studentCompare(Student s1, Student s2, SortingType sortingType) {
        switch (sortingType.getSortby()) {
            case name:
                if (sortingType.getUpDown() == UpDown.up) {
                    return s1.getName().compareTo(s2.getName());
                } else return -1 * s1.getName().compareTo(s2.getName());
            case age:
                if (sortingType.getUpDown() == UpDown.up) {
                    return Integer.compare(s1.getAge(), s2.getAge());
                } else return -1 * Integer.compare(s1.getAge(), s2.getAge());
            case sex:
                if (sortingType.getUpDown() == UpDown.up) {
                    return s1.getSex().toString().compareTo(s2.getSex().toString());
                } else return -1 * s1.getSex().toString().compareTo(s2.getSex().toString());
            case faculty:
                if (sortingType.getUpDown() == UpDown.up) {
                    return s1.getFaculty().toString().compareTo(s2.getFaculty().toString());
                } else return -1 * s1.getFaculty().toString().compareTo(s2.getFaculty().toString());
        }
        return 0;
    }

    public Student[] bubbleSort(Student[] students, SortingType sortingType) {
        if(students.length == 1){
            return students;
        }
        boolean sorted = false;
        Student temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < students.length - 1; i++) {
                if (studentCompare(students[i], students[i + 1], sortingType) > 0) {
                    temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return students;
    }

    private static boolean checkStudent(Student student) {
        boolean rezult = true;
        if (student.getName().trim().equals("")) {
            rezult = false;
            throw new NullPointerException("Не указано фио!!");
        }
        if (student.getAge() == 0) {
            rezult = false;
            throw new NullPointerException("Не заполнен возраст!!");
        }
        if (student.getSex() == null) {
            rezult = false;
            throw new NullPointerException("Не заполнен пол!!");
        }
        if (student.getFaculty().trim().equals("")) {
            rezult = false;
            throw new NullPointerException("Не указан факлуьтет!!");
        }
        return rezult;
    }

    public static StudentGroup createGroupeIntaractive() throws IOException, MembersOutOfSize {
        StudentGroup studentGroup = new StudentGroup();

        ConsoleHelper.printMessage("Введите количество студентов, но не более 10:");
        int count = ConsoleHelper.readInt();
        if (count == 0 || count > 10) {
            ConsoleHelper.printMessage("Досвидание!!!");
            return studentGroup;
        }
        Student student;
        for (int i = 1; i <= count; i++) {
            ConsoleHelper.printMessage("Водим данные " + i + " студента");
            ConsoleHelper.printMessage("Введите фио студента");
            student = new Student();
            student.setName(ConsoleHelper.readString());
            ConsoleHelper.printMessage("Введите возраст");
            student.setAge(ConsoleHelper.readInt());
            ConsoleHelper.printMessage("Введите пол - 'F' или 'M'");
            student.setSex(ConsoleHelper.readSex());
            ConsoleHelper.printMessage("Введите факультет");
            ConsoleHelper.readString();
            try {
                if (checkStudent(student)) studentGroup.add(student);
            } catch ( NullPointerException e){
                ConsoleHelper.printMessage(e.getMessage());
                ConsoleHelper.printMessage("Студент не добавлен в группу");
            }

        }
        return studentGroup;
    }

    public void saveToFile(String path) {

        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(path)))){
            os.writeObject(this);
            os.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static StudentGroup loadFromFile(String path) {
        StudentGroup studentGroup = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))) {
           studentGroup = (StudentGroup) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return studentGroup;

    }

    @Override
    public Student[] searchPrizivnik() {
        int count = 0;
        for(int i = 0;i<members.length;i++){
            if(members[i]!=null && members[i].getAge()>18) count++;
        }
        Student[] prizivniki = new Student[count];
        for(int i = 0;i<members.length;i++){
            if(members[i]!=null && members[i].getAge()>18) prizivniki[i]=members[i];
        }
        return prizivniki;
    }

    @Override
    public String toString() {
        Student[] students;
        int count = 0;
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null) count++;
        }
        students = new Student[count];
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null) students[i] = members[i];
        }
        //Collections.sort(students,comparator);
        SortingType sortingType = new SortingType(Sortby.name, UpDown.up);
        students = bubbleSort(students, sortingType);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            sb.append(students[i]).append(",");
        }

        return "StudentGroup{" +
                "members= " + sb.toString() +
                '}';
    }
}

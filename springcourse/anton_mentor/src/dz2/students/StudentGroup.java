package dz2.students;

import java.util.*;
import java.util.stream.Collectors;

public class StudentGroup {
    private Student[] members = new Student[10];
    private int count = 1;

    public StudentGroup() {
    }

    public void add(Student student) throws MembersOutOfSize {
        if (studentInGroup(student)) {
            return;
        }
        this.count = this.count + 1;
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
                .filter(member->member!=null && member.getName().equalsIgnoreCase(name))
                .findFirst();
        if (student.isPresent()) return student.get();
        return null;
    }

    public void remove(Student student) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == student) {
                this.members[i] = null;
                this.count = this.count - 1;
                break;
            }
        }
    }

    private boolean studentInGroup(Student student) {
        return Arrays.asList(this.members).contains(student);
    }

    @Override
    public String toString() {
        Comparator<Student> comparator = Comparator.comparing(
                Student::getName, (s1, s2) -> {
                    return s1.compareTo(s2);
                }
        );
        List<Student> students = new ArrayList();
        for(int i = 0;i<members.length;i++){
            if(members[i]!=null){
                students.add(members[i]);
            }
        }
        Collections.sort(students,comparator);
        return "StudentGroup{" +
                "members=" + students +
                '}';
    }
}

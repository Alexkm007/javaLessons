package dz2.students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentGroup {
    private Student[] members;
    private final int MEMBERSSIZE = 10;
    private int count = 1;

    public StudentGroup() {
        members = new Student[MEMBERSSIZE];
    }

    public void  add(Student student) throws MembersOutOfSize {
        if(count==MEMBERSSIZE+1){
            throw new MembersOutOfSize();
        }
        if(studentInGroup(student)){
            return;
        }
        count++;
        for(int i = 0;i<MEMBERSSIZE;i++){
            if(members[i]==null){
                members[i] = student;
                break;
            }
        }
    }
    public int getMEMBERSSIZE() {
        return MEMBERSSIZE;
    }

    public Student searchStudent(String name){
        Optional<Student> student = Arrays.asList(members).stream()
                            .filter(member->member.equals(name))
                            .findAny();
        if(student.isPresent()) return student.get();
        return null;
    }

    public void remove(Student student){
        for(int i =0; i<MEMBERSSIZE;i++){
            if(members[i]==student){
                members[i]=null;
                count--;
                break;
            }
        }
    }

    private boolean studentInGroup(Student student){
      return Arrays.asList(members).stream()
                .filter(member->member==student)
                .count() > 0;

    }

    @Override
    public String toString() {

        Comparator<Student> comparator = Comparator.comparing(
                Student::getName,(s1,s2) ->{
                    return s1.compareTo(s2);
                }
        );

        return "StudentGroup{" +
                "members=" + Arrays.asList(members).stream()
                .filter(member->member!=null)
                .sorted(comparator).collect(Collectors.toList()) +
                '}';
    }
}

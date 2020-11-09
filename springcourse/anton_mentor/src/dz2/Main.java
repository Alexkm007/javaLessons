package dz2;

import dz2.students.MembersOutOfSize;
import dz2.students.Sex;
import dz2.students.Student;
import dz2.students.StudentGroup;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ivanov",20, Sex.MALE,"Computer Science");
        Student student2 = new Student("Petrov",20,Sex.MALE,"Computer Science");
        Student student3 = new Student("Abramov",20,Sex.MALE,"Computer Science");
        Student student4 = new Student("Error",22,Sex.FEMALE,"Computer Science");
        StudentGroup sg = new StudentGroup();

        try {
        sg.add(student);
        sg.add(student2);
        sg.add(student3);
        sg.add(student4);
        System.out.println(sg);
        sg.remove(student4);
        System.out.println(sg);
        //тут проверяем что если больше размера группы то ошибка
           for (int i = 0; i <= sg.getMembersLength(); i++) {
               sg.add(new Student("test" + i, 20 + i, Sex.MALE,"Computer Science"));
           }
       }catch (MembersOutOfSize e){
           System.out.println(e.getMessage());
       }
        //Сделал проверку на null теперь не падает
        Student testsearch = sg.searchStudent("Abramov");
        System.out.println(testsearch);
        System.out.println(sg);
    }
}

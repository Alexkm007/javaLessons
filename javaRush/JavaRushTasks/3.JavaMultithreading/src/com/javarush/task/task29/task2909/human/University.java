package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University(String name, int age) {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student student:students){
            if(student.getAverageGrade()==averageGrade){
                return student;
            }
        };
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student student_ = null;
        double maxAverageGrade = Double.MIN_VALUE;
        for(Student student:students){
            if(student.getAverageGrade()>maxAverageGrade){
                student_ = student;
                maxAverageGrade = student.getAverageGrade();
            }

        };
       return student_;
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }
    public Student getStudentWithMinAverageGrade(){
        Student student_ = null;
        double minAverageGrade = Double.MAX_VALUE;
        for(Student student:students){
            if(student.getAverageGrade()<minAverageGrade){
                student_ = student;
                minAverageGrade = student.getAverageGrade();
            }

        };
        return student_;
    }

    public void expel(Student student){
        students.remove(student);
    }

}
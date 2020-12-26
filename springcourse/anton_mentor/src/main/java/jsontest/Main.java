package jsontest;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Alexandr", "Ts",35,"PN121");
        JsonWorker.saveToGsonFile(student,new File("./src/main/java/jsontest/a.json"));
        Student studentOne = JsonWorker.StudentloadFromGson(new File("./src/main/java/jsontest/a.json"));
        System.out.println(studentOne);

    }
}

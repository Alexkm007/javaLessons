package jsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class JsonWorker {
    public static void saveToGsonFile(Student student, File file){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonSt = gson.toJson(student);
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println(gsonSt);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Student StudentloadFromGson(File file){
        Gson gson = new Gson();
        Student student = null;

        try {
            student = gson.fromJson(new FileReader(file),Student.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

}

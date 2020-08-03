package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = File.createTempFile("temp","");
        FileInputStream fileInput = new FileInputStream(file);
        FileOutputStream fileOutput = new FileOutputStream(file);

        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution savedObject = new Solution(34);
        outputStream.writeObject(savedObject);
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);
        Solution loadedObject = (Solution)inputStream.readObject();

        System.out.println(savedObject);
        System.out.println(loadedObject);
        if (savedObject.equals(loadedObject)) System.out.println("yes");
        else System.out.println("no");


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        return string != null ? string.equals(solution.string) : solution.string == null;
    }

    @Override
    public int hashCode() {
        return string != null ? string.hashCode() : 0;
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;


    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

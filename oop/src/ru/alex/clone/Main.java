package ru.alex.clone;

public class Main {

    public static void main(String[] args) {

        A a = new A();
        a.setField("hi hi");
        A b = null;
        try {
            b  = a.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(b);
    }

}

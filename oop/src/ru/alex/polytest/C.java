package ru.alex.polytest;

public class C extends B{
    public C(String name) {
        super(name);
    }

    static void printName(C b){
        b.print();
    }

    void printTest(){
        System.out.println("test");
    }
}


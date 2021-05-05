package ru.alex.innernested;

public class Main {
    public static void main(String[] args) {

        A a = new A();

        A.staticInnerB classInnerB = new A.staticInnerB();
        classInnerB.Print();
        classInnerB.printName(a);
        a.testsAnonymous.printTest();

        A.staticInnerB.staticPrint();

        A.innerB innerB = a.new innerB();
        innerB.printName();
   
    }
}

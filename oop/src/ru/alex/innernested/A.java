package ru.alex.innernested;

public class A {

    private String name = "Test";

    TestsAnonymous testsAnonymous = new TestsAnonymous() {
        @Override
        public void printTest() {
            System.out.println("Anonymous hi");
        }
    };



    void printHi(){
        System.out.println("hi");
    }

    static void staticPrintHi(){
        System.out.println("hi");

        TestsAnonymous testsAnonymous = new TestsAnonymous() {
            @Override
            public void printTest() {
                System.out.println("Anonymous hi");
            }
        };
        testsAnonymous.printTest();
    }

    class innerB{

        void printName(){
            System.out.println(name);
        }


    }

    static class staticInnerB{

        void Print(){
            System.out.println("non static in static");
        }

        void printName(A a){
            System.out.println(a.name);
        }

        static void staticPrint(){
            System.out.println("static in static");
        }

        static void staticPrintName(A a){
            System.out.println(a.name);
        }

    }


}

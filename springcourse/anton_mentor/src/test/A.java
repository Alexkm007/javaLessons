package test;

public interface A {
   int count = 10;

    default void test1(){
        System.out.println("Test1");
    }

    static void test2(){

    }
}

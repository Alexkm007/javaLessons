package test;

import java.io.File;

public class B implements A,A2 {
    public B() {
    }

    @Override
    public void test1() {
        System.out.println("Test B");
    }

    public void hi(){
        System.out.println("Hi");
        File ls = new File("");
    }

}

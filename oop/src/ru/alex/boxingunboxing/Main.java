package ru.alex.boxingunboxing;

public class Main {
    public static void main(String[] args) {
        TestUnBoxing test = new TestUnBoxing();
        test.printInt( Integer.valueOf(30));
        test.printInt(30);

        Byte ba = Byte.valueOf((byte) 10);
        ba++;
        System.out.println(ba);

       // ba = ba + 1;
    }
}

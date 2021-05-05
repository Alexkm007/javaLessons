package ru.alex;

public class PrimitivesType {

    public static void main(String[] args) {

        int  a = 5;
        byte b = (byte) a;

        System.out.println(b);

        byte c = 20;
        int f = c;

        System.out.println(c);

        float n = f;
        n = n+0.5f;

        System.out.println(n);

        f = 5;

        int del = (int) (n/f);
        System.out.println(del);

        long lx = 100L;

        float fx = lx;

        System.out.println(lx/fx);


        byte ba = 20;
        byte bb = 30;

        byte bc = (byte)(ba + bb);

        ba++;
        System.out.println(ba);


    }

}

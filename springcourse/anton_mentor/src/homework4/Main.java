package homework4;

import test.A;

public class Main {
    public static void main(String[] args) {
        ArreySumm arreySumm = new ArreySumm();
        arreySumm.initialArrey(100000000);
        System.out.println(arreySumm.summArrey());
    }
}

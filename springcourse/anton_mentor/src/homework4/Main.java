package homework4;

import test.A;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArreySumm arreySumm = new ArreySumm();
        arreySumm.initialArrey(99999999);
        System.out.println("Длительность в однопотоке: " + arreySumm.returnDurationOneThread() + "мс");
        System.out.println("Длительность в многопотоке: " +arreySumm.returnDurationMultiThread(4) + "мс");
    }
}

package homework5.part1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Ship> shipList = new ArrayList<>();
        shipList.add(new Ship("Беда", 10));
        shipList.add(new Ship("Селезень", 10));
        shipList.add(new Ship("Проворный", 10));

        Harbor harbor = new Harbor(2, shipList);
        harbor.unloadShips();

    }
}

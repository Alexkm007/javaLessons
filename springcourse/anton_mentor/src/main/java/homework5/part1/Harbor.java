package homework5.part1;

import java.util.List;
import java.util.concurrent.*;

public class Harbor {
    private int countDoсks;
    private List<Ship> ships;

    public Harbor() {
    }

    public Harbor(int countDoсks, List<Ship> ships) {
        this.countDoсks = countDoсks;
        this.ships = ships;
    }

    public int getCountDoсks() {
        return countDoсks;
    }

    public void setCountDoсks(int countDoсks) {
        this.countDoсks = countDoсks;
    }

    public List<Ship> getShips() {
        return ships;
    }

    private void setShips(List<Ship> ships) {
        this.ships = ships;
    }


    public void unloadShip(Semaphore docks, Ship ship) {
        try {
            System.out.println("Ожидаем освобождения дока для постановки судна " + ship.getName() + " на разгрузку в док");
            docks.acquire();
            System.out.println("Судно " + ship.getName() + " в доке начинаем разгрузку");
            for (int i = 1; i <= ship.getCountOfBoxes(); i = i + 1) {
                System.out.println("Выгрузили " + i + " ящик c судна " + ship.getName());
                Thread.sleep(500);
            }
            System.out.println("Судно " + ship.getName() + " освобождает док");
            docks.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unloadShips() {
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(ships.size());
        Semaphore docks = new Semaphore(countDoсks);
        for (Ship ship : ships) {
            Runnable taskUnloadShip = new Runnable() {
                @Override
                public void run() {
                    unloadShip(docks, ship);
                }
            };
            threadPoolExecutor.submit(taskUnloadShip);
        }
        threadPoolExecutor.shutdown();
    }
}

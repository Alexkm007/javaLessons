package ru.alexkm07;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alexkm07.dao.CarDAO;
import ru.alexkm07.dao.DAO;
import ru.alexkm07.dao.EngineDAO;
import ru.alexkm07.model.Car;
import ru.alexkm07.model.Engine;

import java.util.HashSet;
import java.util.Set;


public class ApplicationDemo {
    public static void main(String[] args) {

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();

            DAO<Engine, Integer> engineDao = new EngineDAO(factory);
            DAO<Car, Integer> carDao = new CarDAO<>(factory);

            readEngine(engineDao);

//            readCar(carDao);

        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    private static void readEngine(DAO<Engine, Integer> engineDao) {
        final Engine result = engineDao.read(1);
        System.out.println("Read: " + result);
    }

    private static void readCar(DAO<Car, Integer> carDao) {
        final Car result = carDao.read(1);
        System.out.println("Read: " + result);
    }
}
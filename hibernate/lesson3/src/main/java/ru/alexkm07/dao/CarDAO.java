package ru.alexkm07.dao;

import com.sun.istack.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexkm07.model.Car;

public class CarDAO<Entity, Key> implements DAO<Car, Integer> {
    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    public CarDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Car read(Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Car.class, id);
        }
    }
}

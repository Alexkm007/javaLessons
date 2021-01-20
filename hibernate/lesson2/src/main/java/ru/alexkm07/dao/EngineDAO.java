package ru.alexkm07.dao;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexkm07.model.Engine;

public class EngineDAO implements DAO<Engine, Integer> {

    private final SessionFactory factory;

    public EngineDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Engine engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(engine);

            session.getTransaction().commit();
        }
    }


    @Override
    public Engine read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Engine.class, id);
        }
    }

    @Override
    public void update(Engine engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(engine);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Engine engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(engine);

            session.getTransaction().commit();
        }
    }
}

package ru.alexkm07.dao;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexkm07.model.Engine;

public class EngineDAO implements DAO<Engine, String> {

    private final SessionFactory factory;

    public EngineDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Engine engine) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();
            session.save(engine);
            session.getTransaction().commit();
        }
    }

    @Override
    public Engine read(@NotNull final String model) {
        try (final Session session = factory.openSession()) {

            final Engine result = session.get(Engine.class, model);
            return result != null ? result : new Engine();
        }
    }

    @Override
    public void update(@NotNull final Engine engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();
            session.update(engine);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Engine engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(engine);

            session.getTransaction().commit();
        }
    }
}

package ru.alexkm07.dao;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.alexkm07.model.OrderRow;

@AllArgsConstructor
public class OrderRowDao implements Dao<OrderRow,Integer> {
    @Setter
    private final SessionFactory factory;

    @Override
    public OrderRow read(Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(OrderRow.class, id);
        }
    }

    @Override
    public void create(final OrderRow obj) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        }
    }

    @Override
    public void update(OrderRow obj) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        }
    }

    @Override
    public void delete(OrderRow obj) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        }
    }
}

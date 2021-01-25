package ru.alexkm07.dao;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.alexkm07.model.Customer;
import ru.alexkm07.model.Order;

@AllArgsConstructor
public class OrderDao implements Dao<Order,Integer>{
    @Setter
    private final SessionFactory factory;

    @Override
    public Order read(Integer id) {
        try (final Session session = factory.openSession()) {
            Order order = session.get(Order.class, id);
            if (order != null) {
                Hibernate.initialize(order.getOrderRowList());
            }
            return order;
        }
    }
    @Override
    public void create(Order obj) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        }
    }

    @Override
    public void update(Order obj) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        }
    }

    @Override
    public void delete(Order obj) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        }
    }
}

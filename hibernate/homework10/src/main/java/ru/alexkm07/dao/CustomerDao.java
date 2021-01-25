package ru.alexkm07.dao;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.alexkm07.model.Customer;

@AllArgsConstructor
public class CustomerDao implements Dao<Customer, Integer>{

    @Setter
    private final SessionFactory factory;

    @Override
    public Customer read(Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Customer.class, id);
        }
    }

    @Override
    public void create(final Customer obj) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        }
    }

    @Override
    public void update(Customer obj) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        }
    }

    @Override
    public void delete(Customer obj) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        }
    }
}


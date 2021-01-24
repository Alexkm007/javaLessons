package ru.alexkm07.dao;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.alexkm07.model.Customer;
import ru.alexkm07.model.Product;

@AllArgsConstructor
public class ProductDao implements Dao<Product,Integer>{
    @Setter
    private final SessionFactory factory;

    @Override
    public Product read(Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Product.class, id);
        }
    }

    @Override
    public void create(final Product obj) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        }
    }

    @Override
    public void update(Product obj) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        }
    }

    @Override
    public void delete(Product obj) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        }
    }
}

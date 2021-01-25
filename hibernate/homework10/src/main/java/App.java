import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.alexkm07.dao.*;
import ru.alexkm07.model.Customer;
import ru.alexkm07.model.Order;
import ru.alexkm07.model.OrderRow;
import ru.alexkm07.model.Product;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class App {

    private static SessionFactory factory;

    public static void main(String[] args) {

        factory = null;
        try {

            factory = new Configuration().configure().buildSessionFactory();
            Customer customer = createAndSaveCustomer("Fedor E.","N. Oskol Fedor Strt 1");
            System.out.println(customer);

            Product product1 = createAndSaveProduct("test1");
            System.out.println(product1);
            Product product2 = createAndSaveProduct("test2");
            System.out.println(product2);

            Order order = createAndSaveOrder(new Date(),customer);

            OrderRow orderRow1 = createAndSaveOrderRow(order,product1,150.32,50.00);
            OrderRow orderRow2 = createAndSaveOrderRow(order,product2,1000.39,100.00);

            order.addRow(orderRow1);
            order.addRow(orderRow2);
            updateOrder(order);

            List<Order> orderList = getOrders();
            System.out.println("Список заказов из базы");
            System.out.println(orderList);
            System.out.println("--------------");

            Order order2 = readOrder(1);
            System.out.println(order2);
            deleteOrder(order2);
            order2 = readOrder(1);
            System.out.println(order2);

        }finally {
            factory.close();
        }

    }

    public static Customer createAndSaveCustomer(String name,String address){
        Customer customer = new Customer(name,address);
        Dao<Customer, Integer> dao = new CustomerDao(factory);
        dao.create(customer);
        return customer;
    }

    public static Product createAndSaveProduct( String name){
        Product product = new Product(name);
        Dao<Product, Integer> dao = new ProductDao(factory);
        dao.create(product);
        return product;
    }

    public static Order createAndSaveOrder(Date date, Customer customer){
        Order order = new Order(date, customer, 0, 0, new HashSet<OrderRow>() {
        });
        Dao<Order, Integer> dao = new OrderDao(factory);
        dao.create(order);
        return order;
    }

    public static OrderRow createAndSaveOrderRow(Order order, Product product,
                                              Double price, Double quantity){
        OrderRow orderRow = new OrderRow(product, order,price,quantity,price*quantity);
        Dao<OrderRow, Integer> dao = new OrderRowDao(factory);
        dao.create(orderRow);
        return orderRow;

    }

    public static void updateOrder(Order order){
        Dao<Order, Integer> dao = new OrderDao(factory);
        dao.update(order);
    }

    public static Order readOrder(int id){
        Dao<Order, Integer> dao = new OrderDao(factory);
        return dao.read(id);
    }

    public static void deleteOrder(Order order){
        Dao<Order, Integer> dao = new OrderDao(factory);
        dao.delete(order);
    }


    public static List<Order> getOrders(){
        Query query = factory.openSession().createQuery("FROM Order");
        return query.getResultList();
    }

}

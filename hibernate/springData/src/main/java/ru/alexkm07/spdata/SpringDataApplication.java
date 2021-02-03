package ru.alexkm07.spdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.alexkm07.spdata.model.Customer;
import ru.alexkm07.spdata.model.Order;
import ru.alexkm07.spdata.model.OrderRow;
import ru.alexkm07.spdata.model.Product;
import ru.alexkm07.spdata.service.CustomerController;
import ru.alexkm07.spdata.service.OrderController;
import ru.alexkm07.spdata.service.OrderRowController;
import ru.alexkm07.spdata.service.ProductController;

import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final CustomerController customerController;
    private final ProductController productController;
    private final OrderController orderController;
    private final OrderRowController orderRowController;

    public SpringDataApplication(CustomerController customerController, ProductController productController, OrderController orderController, OrderRowController orderRowController) {
        this.customerController = customerController;
        this.productController = productController;
        this.orderController = orderController;
        this.orderRowController = orderRowController;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product("Test1");
        Product product2 = new Product("Test2");

        productController.save(product1);
        productController.save(product2);

        Customer customer = new Customer("Bob J","Spb ts 11");
        customerController.save(customer);

        Order order = new Order(new Date(),customer,0,0,new HashSet<OrderRow>());
        orderController.save(order);

        OrderRow orderRow1 = new OrderRow(product1,order,20,100,20*100);
        OrderRow orderRow2 = new OrderRow(product1,order,30.34,100,30.34*100);


        //orderRowController.save(orderRow1);
        //orderRowController.save(orderRow2);

        order.addRow(orderRow1);
        order.addRow(orderRow2);

        orderController.save(order);

        System.out.println(orderController.getByIdAsString(order.getId()));
        orderController.delete(order);

    }
}

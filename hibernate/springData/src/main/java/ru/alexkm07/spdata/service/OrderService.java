package ru.alexkm07.spdata.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexkm07.spdata.model.Customer;
import ru.alexkm07.spdata.model.Order;
import ru.alexkm07.spdata.model.Product;
import ru.alexkm07.spdata.repository.OrderRepository;


import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    public final OrderRepository orderRepository;
    public final CustomerService customerService;
    public final ProductService productService;

    public OrderService(OrderRepository orderRepository, CustomerService customerService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
    }

    public void save(Order order){
        orderRepository.saveAndFlush(order);
    }

    public Order getById(Long id){
        Optional<Order> order= orderRepository.findById(id);
        Order order1 = order.get();
        order1.getOrderRowList();
        order1.getCustomer();
        return order1;
    }

    public void delete(Order order){
        orderRepository.deleteById(order.getId());
    }

    @Transactional(readOnly=true)
    public String getByIdAsString(Long id){
        Optional<Order> order= orderRepository.findById(id);
        return order.get().toString();
    }

    public void updateOrder(Order order,Long id){
        Order orderToUpdate = getById(id);
        orderToUpdate.setCustomer(order.getCustomer());
        orderToUpdate.setTotalAmount(order.getTotalAmount());
        orderToUpdate.setTotalQuantity(order.getTotalQuantity());
        save(orderToUpdate);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public List<Product> getProducts(){
        return productService.findAll();
    }

    public  List<Customer> getCustomers() {
        return customerService.findAll();
    }
}

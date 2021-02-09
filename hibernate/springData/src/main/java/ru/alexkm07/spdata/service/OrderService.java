package ru.alexkm07.spdata.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexkm07.spdata.model.Customer;
import ru.alexkm07.spdata.model.Order;
import ru.alexkm07.spdata.model.OrderRow;
import ru.alexkm07.spdata.model.Product;
import ru.alexkm07.spdata.repository.OrderRepository;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    public final OrderRepository orderRepository;
    public final CustomerService customerService;
    public final ProductService productService;
    public final OrderRowService orderRowService;

    public OrderService(OrderRepository orderRepository, CustomerService customerService, ProductService productService, OrderRowService orderRowService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.orderRowService = orderRowService;
    }

    public Long save(Order order,Long id) {
        Order persOrder = null;
        if(id == 0) {
            persOrder = order;
        }else {
            persOrder = orderRepository.findById(id).get();
            persOrder.setCustomer(order.getCustomer());
            persOrder.setDate(order.getDate());
            if(persOrder.getOrderRowList()!=null){
                persOrder.setTotalAmount(persOrder.getOrderRowList().stream().mapToDouble(i->i.getAmount()).sum());
                persOrder.setTotalQuantity(persOrder.getOrderRowList().stream().mapToDouble(i->i.getQuantity()).sum());
            }
        }
        persOrder = orderRepository.saveAndFlush(persOrder);
        return persOrder.getId();
    }

    public Order getById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        Order order1 = order.get();
        order1.getOrderRowList();
        order1.getCustomer();
        return order1;
    }

    public void delete(Order order) {
        orderRepository.deleteById(order.getId());
    }

    @Transactional(readOnly = true)
    public String getByIdAsString(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get().toString();
    }

    public void updateOrder(Order order, Long id) {
        save(order,id);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public List<Product> getProducts() {
        return productService.findAll();
    }

    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    public void addRow(OrderRow row, Long id, Long id_row){
        OrderRow rowToSave = null;
        Order order = getById(id);
        if(id_row == 0 || id_row==null) {
            row.setOrder(order);
            row.setAmount(row.getPrice() * row.getQuantity());
            rowToSave = row;
        }else {
            rowToSave = orderRowService.getById(id_row);
            rowToSave.setPrice(row.getPrice());
            rowToSave.setQuantity(row.getQuantity());
            rowToSave.setQuantity(rowToSave.getPrice() * rowToSave.getQuantity());
        }
        orderRowService.save(rowToSave);
        save(order,id);
    }

    public void deleteRow(Long id) {
        orderRowService.deleteById(id);
    }

    public OrderRow getRowById(Long id) {
        return orderRowService.getById(id);
    }

    public Set<OrderRow> getOrderRows(Order order) {
        return orderRowService.getOrderRows(order);
    }
}


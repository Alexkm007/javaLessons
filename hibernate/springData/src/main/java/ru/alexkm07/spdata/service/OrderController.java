package ru.alexkm07.spdata.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexkm07.spdata.model.Order;
import ru.alexkm07.spdata.repository.OrderRepository;


import java.util.Optional;
import java.util.Set;

@Service
public class OrderController {

    public final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order){
        orderRepository.save(order);
    }
    //@Transactional
    public Order getById(Integer id){
        Optional<Order> order= orderRepository.findById(id);
        Order order1 = order.get();
        order1.getOrderRowList();
        order1.getCustomer();
        return order1;
    }

    public void delete(Order order){
        orderRepository.delete(order);
    }

    @Transactional(readOnly=true)
    public String getByIdAsString(Integer id){
        Optional<Order> order= orderRepository.findById(id);
        return order.get().toString();
    }


}

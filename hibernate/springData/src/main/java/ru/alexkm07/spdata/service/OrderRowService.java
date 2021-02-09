package ru.alexkm07.spdata.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.spdata.model.Order;
import ru.alexkm07.spdata.model.OrderRow;
import ru.alexkm07.spdata.repository.OrderRowRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class OrderRowService {

   private final OrderRowRepository orderRowRepository;

    public OrderRowService(OrderRowRepository orderRowRepository) {
        this.orderRowRepository = orderRowRepository;
    }

    public void save(OrderRow orderRow){
        orderRowRepository.saveAndFlush(orderRow);
    }

    public OrderRow getById(Long id){
        return orderRowRepository.findById(id).get();
    }

    public void deleteById(Long id){
        orderRowRepository.deleteById(id);
    }

    public Set<OrderRow> getOrderRows(Order order){
        return orderRowRepository.findAllByOrder(order);
    }

}

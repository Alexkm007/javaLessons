package ru.alexkm07.spdata.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.spdata.model.OrderRow;
import ru.alexkm07.spdata.repository.OrderRowRepository;

import java.util.Optional;

@Service
public class OrderRowController {

   private final OrderRowRepository orderRowRepository;

    public OrderRowController(OrderRowRepository orderRowRepository) {
        this.orderRowRepository = orderRowRepository;
    }

    public void save(OrderRow orderRow){
        orderRowRepository.save(orderRow);
    }

    public OrderRow getById(Long id){
        Optional<OrderRow> orderRow = orderRowRepository.findById(id);
        return orderRow.get();
    }

}

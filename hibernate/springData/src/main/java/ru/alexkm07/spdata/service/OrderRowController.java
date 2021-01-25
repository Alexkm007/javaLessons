package ru.alexkm07.spdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.alexkm07.spdata.model.OrderRow;
import ru.alexkm07.spdata.repository.OrderRowRepository;

import java.util.Optional;

@Service
public class OrderRowController {
    @Autowired
    OrderRowRepository orderRowRepository;

    public void save(OrderRow orderRow){
        orderRowRepository.save(orderRow);
    }

    public OrderRow getById(Integer id){
        Optional<OrderRow> orderRow = orderRowRepository.findById(id);
        return orderRow.get();
    }

}

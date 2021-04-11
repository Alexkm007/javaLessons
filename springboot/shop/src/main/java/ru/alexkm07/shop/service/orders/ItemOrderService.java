package ru.alexkm07.shop.service.orders;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.ItemDto;
import ru.alexkm07.shop.model.documents.orders.ItemBox;
import ru.alexkm07.shop.model.documents.orders.ItemOrder;
import ru.alexkm07.shop.repository.mongo.ItemBoxRepository;
import ru.alexkm07.shop.repository.mongo.ItemOrderRepository;

@Service
public class ItemOrderService extends AbstractService<ItemDto,Long, ItemOrder, ItemOrderRepository>{

    public ItemOrderService(ItemOrderRepository repo) {
        super(repo);
    }
}

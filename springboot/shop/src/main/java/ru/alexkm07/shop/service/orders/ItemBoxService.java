package ru.alexkm07.shop.service.orders;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.ItemDto;
import ru.alexkm07.shop.model.documents.orders.ItemBox;
import ru.alexkm07.shop.repository.mongo.ItemBoxRepository;
import ru.alexkm07.shop.service.util.AbstractService;

@Service
public class ItemBoxService extends AbstractService<ItemDto,Long, ItemBox, ItemBoxRepository> {

    public ItemBoxService(ItemBoxRepository repo) {
        super(repo);
    }
}

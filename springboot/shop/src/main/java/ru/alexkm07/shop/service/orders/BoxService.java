package ru.alexkm07.shop.service.orders;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.BoxDto;
import ru.alexkm07.shop.model.documents.orders.Box;
import ru.alexkm07.shop.repository.mongo.BoxRepository;
import ru.alexkm07.shop.service.util.AbstractService;

@Service
public class BoxService extends AbstractService<BoxDto,Long, Box, BoxRepository> {

    public BoxService(BoxRepository repo) {
        super(repo);
    }
}

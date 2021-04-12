package ru.alexkm07.shop.service.reference;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.CountryDto;
import ru.alexkm07.shop.dto.ItemDto;
import ru.alexkm07.shop.model.documents.orders.Order;
import ru.alexkm07.shop.model.documents.reference.Country;
import ru.alexkm07.shop.repository.mongo.CountryRepository;
import ru.alexkm07.shop.repository.mongo.OrderRepository;
import ru.alexkm07.shop.service.util.AbstractService;

@Service
public class CountryService extends AbstractService<CountryDto,Long, Country, CountryRepository> {

    public CountryService(CountryRepository repo) {
        super(repo);
    }
}

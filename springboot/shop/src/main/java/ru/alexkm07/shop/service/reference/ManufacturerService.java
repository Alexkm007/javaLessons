package ru.alexkm07.shop.service.reference;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.CountryDto;
import ru.alexkm07.shop.dto.ManufacturerDto;
import ru.alexkm07.shop.model.documents.reference.Country;
import ru.alexkm07.shop.model.documents.reference.Manufacturer;
import ru.alexkm07.shop.repository.mongo.CountryRepository;
import ru.alexkm07.shop.repository.mongo.ManufacturerRepository;
import ru.alexkm07.shop.service.util.AbstractService;

@Service
public class ManufacturerService extends AbstractService<ManufacturerDto,Long, Manufacturer, ManufacturerRepository> {

    public ManufacturerService(ManufacturerRepository repo) {
        super(repo);
    }
}

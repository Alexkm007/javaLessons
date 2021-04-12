package ru.alexkm07.shop.service.reference;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.ManufacturerDto;
import ru.alexkm07.shop.dto.UnitDto;
import ru.alexkm07.shop.model.documents.reference.Manufacturer;
import ru.alexkm07.shop.model.documents.reference.Unit;
import ru.alexkm07.shop.repository.mongo.ManufacturerRepository;
import ru.alexkm07.shop.repository.mongo.UnitRepository;
import ru.alexkm07.shop.service.util.AbstractService;

@Service
public class UnitService extends AbstractService<UnitDto,Long, Unit, UnitRepository> {

    public UnitService(UnitRepository repo) {
        super(repo);
    }
}

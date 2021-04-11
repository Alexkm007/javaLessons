package ru.alexkm07.shop.service.orders;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.FolderDto;
import ru.alexkm07.shop.model.documents.products.Folder;
import ru.alexkm07.shop.repository.mongo.FolderRepository;

@Service
public class FolderService extends AbstractService<FolderDto,Long, Folder, FolderRepository>{

    public FolderService(FolderRepository repo) {
        super(repo);
    }
}

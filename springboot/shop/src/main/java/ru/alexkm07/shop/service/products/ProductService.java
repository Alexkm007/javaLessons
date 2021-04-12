package ru.alexkm07.shop.service.products;

import org.springframework.stereotype.Service;
import ru.alexkm07.shop.dto.ProductDto;
import ru.alexkm07.shop.model.documents.products.Product;
import ru.alexkm07.shop.repository.mongo.ProductRepository;
import ru.alexkm07.shop.service.util.AbstractService;

@Service
public class ProductService extends AbstractService<ProductDto,Long, Product, ProductRepository> {

    public ProductService(ProductRepository repo) {
        super(repo);
    }
}

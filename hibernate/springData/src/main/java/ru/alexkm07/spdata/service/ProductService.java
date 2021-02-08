package ru.alexkm07.spdata.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.alexkm07.spdata.model.Product;
import ru.alexkm07.spdata.repository.ProductRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product productById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void update(Product product, Long id) {
        Product productToUpdate = productById(id);
        productToUpdate.setName(product.getName());
        save(productToUpdate);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}

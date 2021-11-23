package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.ProductRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product registerProduct(Product product) {
        productRepository.findById(product.getId()).ifPresent(p -> {
                    throw new RuntimeException("same product is already registered: " + p.getId());
                });
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product found = productRepository.findById(product.getId()).orElseThrow();
        found.setPrice(product.getPrice());
        return productRepository.save(found);
    }
}

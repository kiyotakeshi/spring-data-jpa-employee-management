package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.model.request.ProductUpdateRequest;
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
            // ユーザにエラーメッセージとして返す実装にしてもいい
            throw new RuntimeException("same product is already registered: " + p.getId());
        });
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String categoryName, String productName, ProductUpdateRequest request) {
        var product = productRepository.findById(new Product.Id(categoryName, productName)).orElseThrow();
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }
}

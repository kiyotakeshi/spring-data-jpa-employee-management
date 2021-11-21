package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product registerProduct(Product product);

    Product updateProduct(Product product);
}

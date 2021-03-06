package com.kiyotakeshi.employeeManagement.controller;

import com.kiyotakeshi.employeeManagement.model.request.ProductUpdateRequest;
import com.kiyotakeshi.employeeManagement.repository.entity.Product;
import com.kiyotakeshi.employeeManagement.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> list() {
        return productService.getProducts();
    }

    @PostMapping
    public Product register(@RequestBody Product request) {
        return productService.registerProduct(request);
    }

    // /products?categoryName=&productName=
    @PutMapping(params = {"categoryName", "productName"})
    public Product update(@RequestParam(name = "categoryName") String categoryName,
                          @RequestParam(name = "productName") String productName,
                          @RequestBody ProductUpdateRequest request) {
        return productService.updateProduct(categoryName, productName, request);
    }
}

package com.bhargavi.stockguard.service;

import com.bhargavi.stockguard.model.Product;
import com.bhargavi.stockguard.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public Product addProduct(Product product) { return productRepo.save(product); }
    public List<Product> getAllProducts() { return productRepo.findAll(); }
    public Optional<Product> getProductById(Long id) { return productRepo.findById(id); }
}
package com.bhargavi.stockguard.repo;

import com.bhargavi.stockguard.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
package com.bhargavi.stockguard.service;

import com.bhargavi.stockguard.model.Order;
import com.bhargavi.stockguard.model.Product;
import com.bhargavi.stockguard.repo.OrderRepo;
import com.bhargavi.stockguard.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    public OrderService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public Order placeOrder(Long productId, Integer quantity) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getStock() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        product.setStock(product.getStock() - quantity);
        productRepo.save(product);

        Order order = new Order();
        order.setProduct(product);
        order.setQuantity(quantity);
        return orderRepo.save(order);
    }


    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }
}

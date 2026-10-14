package com.bhargavi.stockguard.repo;

import com.bhargavi.stockguard.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}

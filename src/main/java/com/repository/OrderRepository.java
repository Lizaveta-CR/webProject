package com.repository;

import com.domain.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAll();

    void save(Order order);

    void delete(Order order);

    Order getOrderById(Integer id);

    void update(Order order);
}

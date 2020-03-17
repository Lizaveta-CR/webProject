package com.service;

import com.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    void save(Order order);

    void delete(int id);

    Order getOrderById(Integer id);

    void update(Order order);
}

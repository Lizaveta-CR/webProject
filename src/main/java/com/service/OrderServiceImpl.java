package com.service;

import com.domain.Order;
import com.repository.OrderRepository;
import com.repository.OrderRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderRepository repository = new OrderRepositoryImpl();

    @Override
    public List<Order> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public void delete(Order order) {
        if (order != null) {
            repository.delete(order);
        }
    }

    @Override
    public Order getOrderById(Integer id) {
        if (id != null) {
            return repository.getOrderById(id);
        }
        return null;
    }

    @Override
    public void update(Order order) {
        if (order != null) {
            repository.update(order);
        }
    }
}

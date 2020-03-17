package com.service;

import com.domain.Order;
import com.repository.OrderRepository;
import com.repository.OrderRepositoryImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderRepository repository = new OrderRepositoryImpl();

    @Override
    @Transactional
    public List<Order> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    @Transactional
    public Order getOrderById(Integer id) {
        return repository.getOrderById(id);
    }

    @Override
    @Transactional
    public void update(Order order) {
        repository.update(order);
    }
}

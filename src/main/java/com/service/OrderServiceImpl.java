package com.service;

import com.domain.Order;
import com.repository.OrderRepository;
import com.repository.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository repository;

    @Override
    public List<Order> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Order getOrderById(Integer id) {
        return repository.getOrderById(id);
    }

    @Override
    public void update(Order order) {
        repository.update(order);
    }
}

package com.repository;

import com.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    List<Order> orders = new ArrayList<>();

    public OrderRepositoryImpl() {
        Order orderF = new Order();
        orderF.setId(1);
        orderF.setName("Pineapple");
        orderF.setPrice(3.5);
        orders.add(orderF);

        Order orderS = new Order();
        orderS.setId(2);
        orderS.setName("Watermelon");
        orderS.setPrice(4.1);
        orders.add(orderS);
    }

    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public void delete(Order order) {
        orders.remove(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void update(Order order) {
        Order orderGet = orders.get(order.getId());

        orderGet.setName(order.getName());
        orderGet.setPrice(order.getPrice());
    }
}

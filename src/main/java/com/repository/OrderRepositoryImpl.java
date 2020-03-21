package com.repository;

import com.domain.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Order> getAll() {
        Criteria criteria = getSession().createCriteria(Order.class);
        return (List) criteria.list();
    }

    @Override
    public void save(Order order) {
        getSession().save(order);
    }

    @Override
    public void delete(int id) {
        Order order = (Order) getSession().get(Order.class, id);
        getSession().delete(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        Order order = (Order) getSession().get(Order.class, id);
        return order;
    }

    @Override
    public void update(Order order) {
        getSession().update(order);
    }
}

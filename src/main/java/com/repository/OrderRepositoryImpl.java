package com.repository;

import com.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Order> getAll() {
        Query from_order = getSession().createQuery("from Order");
        List resultList = from_order.getResultList();
        return resultList;
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

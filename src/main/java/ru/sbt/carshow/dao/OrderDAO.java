package ru.sbt.carshow.dao;

import ru.sbt.carshow.model.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAll();
    Order getById(long id);
    long add(Order order);
    void delete(Order order);
    void update(Order order);
    int count();
    int clear();

}

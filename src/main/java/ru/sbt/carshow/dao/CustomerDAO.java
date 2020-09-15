package ru.sbt.carshow.dao;

import ru.sbt.carshow.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll();
    Customer getById(long id);
    long add(Customer customer);
    void delete(Customer customer);
    void update(Customer customer);
    int count();
    int clear();
}

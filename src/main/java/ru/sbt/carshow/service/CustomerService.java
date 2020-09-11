package ru.sbt.carshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.carshow.dao.CustomerDAO;
import ru.sbt.carshow.model.Customer;

import java.util.List;

@Component
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    public Customer getById(long id) {
        return customerDAO.getById(id);
    }

    public long add(Customer customer) {
        return customerDAO.add(customer);
    }

    public void delete(Customer customer) {
        customerDAO.delete(customer);
    }

    public void edit(Customer customer) {
        customerDAO.edit(customer);
    }

    public int count() {
        return customerDAO.count();
    }

    public int clear() {
        return customerDAO.clear();
    }
}

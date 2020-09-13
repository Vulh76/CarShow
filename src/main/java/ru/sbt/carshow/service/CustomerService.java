package ru.sbt.carshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.carshow.dao.CustomerDAO;
import ru.sbt.carshow.model.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Transactional
    public Customer getById(long id) {
        return customerDAO.getById(id);
    }

    @Transactional
    public long add(Customer customer) {
        return customerDAO.add(customer);
    }

    @Transactional
    public void delete(Customer customer) {
        customerDAO.delete(customer);
    }

    @Transactional
    public void edit(Customer customer) {
        customerDAO.edit(customer);
    }

    @Transactional
    public int count() {
        return customerDAO.count();
    }

    @Transactional
    public int clear() {
        return customerDAO.clear();
    }
}

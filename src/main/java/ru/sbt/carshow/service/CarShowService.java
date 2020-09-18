package ru.sbt.carshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.carshow.dao.CarDAO;
import ru.sbt.carshow.dao.CustomerDAO;
import ru.sbt.carshow.dao.OrderDAO;
import ru.sbt.carshow.dao.OrderDAOImpl;
import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.model.Order;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarShowService {

    private final CustomerDAO customerDAO;
    private final CarDAO carDAO;
    private final OrderDAO orderDAO;

    @Autowired
    public CarShowService(CustomerDAO customerDAO, CarDAO carDAO, OrderDAOImpl orderDAO) {
        this.customerDAO = customerDAO;
        this.carDAO = carDAO;
        this.orderDAO = orderDAO;
    }

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getAll();
    }

    @Transactional
    public List<Car> getCar() {
        return carDAO.getAll();
    }

    @Transactional
    public List<Order> getOrders() {
        return orderDAO.getAll();
    }

    @Transactional
    public Customer getCustomer(long id) {
        return customerDAO.getById(id);
    }

    @Transactional
    public Car getCar(long id) {
        return carDAO.getById(id);
    }

    @Transactional
    public Order getOrders(long id) {
        return orderDAO.getById(id);
    }

    @Transactional
    public long addCustomer(Customer customer) {
        return customerDAO.add(customer);
    }

    @Transactional
    public long addCar(Car car) {
        return carDAO.add(car);
    }

    @Transactional
    public long addOrder(Customer customer, Car car) {
        customerDAO.add(customer);
        carDAO.add(car);
        Order order = new Order(customer, car);
        return orderDAO.add(order);
    }

    @Transactional
    public long addOrder(long customerID, long carID) {
        Customer customer = customerDAO.getById(customerID);
        if(customer == null)
            throw new IllegalArgumentException("Не найден киент: " + customerID);
        Car car = carDAO.getById(carID);
        if(car == null)
            throw new IllegalArgumentException("Не найден автомобиль: " + carID);

        Order order = new Order(customer, car);
        return orderDAO.add(order);
    }

    @Transactional
    public long addOrder(Customer customer, long carID) {
        customerDAO.add(customer);
        Car car = carDAO.getById(carID);
        if(car == null)
            throw new IllegalArgumentException("Не найден автомобиль: " + carID);
        Order order = new Order(customer, car);
        return orderDAO.add(order);
    }

    @Transactional
    public List<Car> getCustomerCars(long customerID) {
        Customer customer = customerDAO.getById(customerID);
        if(customer == null)
            throw new IllegalArgumentException("Не найден киент: " + customerID);
        return customer.getOrders().stream().map(Order::getCar).collect(Collectors.toList());
    }

    @Transactional
    public List<Car> getCustomerCars(Customer customer) {
        return customer.getOrders().stream().map(Order::getCar).collect(Collectors.toList());
    }

    @Transactional
    public List<Customer> getCarBuyers(long carID) {
        Car car = carDAO.getById(carID);
        if(car == null)
            throw new IllegalArgumentException("Не найден киент: " + carID);
        return car.getOrders().stream().map(Order::getCustomer).collect(Collectors.toList());
    }

    @Transactional
    public List<Customer> getCarBuyers(Car car) {
        return car.getOrders().stream().map(Order::getCustomer).collect(Collectors.toList());
    }
}

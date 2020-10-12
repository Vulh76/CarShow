package ru.sbt.carshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.carshow.dao.EntityDAO;
import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.model.Order;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarShowServiceImpl implements CarShowService {

    private final EntityDAO entityDAO;

    @Autowired
    public CarShowServiceImpl(EntityDAO entityDAO) {
        this.entityDAO = entityDAO;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return entityDAO.getAll(Customer.class);
    }

    @Override
    @Transactional
    public List<Car> getCar() {
        return entityDAO.getAll(Car.class);
    }

    @Override
    @Transactional
    public List<Order> getOrder() {
        return entityDAO.getAll(Order.class);
    }

    @Override
    @Transactional
    public Customer getCustomer(long id) {
        return entityDAO.getById(Customer.class, id);
    }

    @Override
    @Transactional
    public Car getCar(long id) {
        return entityDAO.getById(Car.class, id);
    }

    @Override
    @Transactional
    public Order getOrder(long id) {
        return entityDAO.getById(Order.class, id);
    }

    @Override
    @Transactional
    public long addCustomer(Customer customer) {
        return entityDAO.add(customer);
    }

    @Override
    @Transactional
    public long addCar(Car car) {
        return entityDAO.add(car);
    }

    @Override
    @Transactional
    public long addOrder(Customer customer, Car car) {
        entityDAO.add(customer);
        entityDAO.add(car);
        Order order = new Order(customer, car);
        return entityDAO.add(order);
    }

    @Override
    @Transactional
    public long addOrder(long customerID, long carID) {
        Customer customer = entityDAO.getById(Customer.class, customerID);
        if(customer == null)
            throw new IllegalArgumentException("Не найден киент: " + customerID);
        Car car = entityDAO.getById(Car.class, carID);
        if(car == null)
            throw new IllegalArgumentException("Не найден автомобиль: " + carID);

        Order order = new Order(customer, car);
        return entityDAO.add(order);
    }

    @Override
    @Transactional
    public long addOrder(Customer customer, long carID) {
        entityDAO.add(customer);
        Car car = entityDAO.getById(Car.class, carID);
        if(car == null)
            throw new IllegalArgumentException("Не найден автомобиль: " + carID);
        Order order = new Order(customer, car);
        return entityDAO.add(order);
    }

    @Override
    @Transactional
    public List<Car> getCustomerCars(long customerID) {
        Customer customer = entityDAO.getById(Customer.class, customerID);
        if(customer == null)
            throw new IllegalArgumentException("Не найден киент: " + customerID);
        return customer.getOrders().stream().map(Order::getCar).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Car> getCustomerCars(Customer customer) {
        return customer.getOrders().stream().map(Order::getCar).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Customer> getCarBuyers(long carID) {
        Car car = entityDAO.getById(Car.class, carID);
        if(car == null)
            throw new IllegalArgumentException("Не найден киент: " + carID);
        return car.getOrders().stream().map(Order::getCustomer).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Customer> getCarBuyers(Car car) {
        return car.getOrders().stream().map(Order::getCustomer).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public long clearOrders() {
        return entityDAO.clear(Order.class);
    }

    @Override
    @Transactional
    public long countOrders() {
        return entityDAO.count(Order.class);
    }
}

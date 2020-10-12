package ru.sbt.carshow.service;

import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.model.Order;

import java.util.List;

public interface CarShowService {
    List<Customer> getCustomers();
    List<Car> getCar();
    List<Order> getOrder();
    Customer getCustomer(long id);
    Car getCar(long id);
    Order getOrder(long id);
    long addCustomer(Customer customer);
    long addCar(Car car);
    long addOrder(Customer customer, Car car);
    long addOrder(long customerID, long carID);
    long addOrder(Customer customer, long carID);
    List<Car> getCustomerCars(long customerID);
    List<Car> getCustomerCars(Customer customer);
    List<Customer> getCarBuyers(long carID);
    List<Customer> getCarBuyers(Car car);
    long clearOrders();
    long countOrders();
}

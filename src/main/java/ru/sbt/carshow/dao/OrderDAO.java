package ru.sbt.carshow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.model.Order;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public class OrderDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Order add(long customerID, long carID) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerID);
        Car car = session.get(Car.class, carID);
        Order order = new Order(LocalDateTime.now(), customer, car);
        customer.addOrder(order);
        return order;
    }
}

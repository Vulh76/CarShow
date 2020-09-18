package ru.sbt.carshow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sbt.carshow.model.Order;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /*@Transactional
    public Order add(long customerID, long carID) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerID);
        Car car = session.get(Car.class, carID);
        Order order = new Order(customer, car);
        customer.addOrder(order);
        return order;
    }*/

    @Override
    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order").list();
    }

    @Override
    public Order getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    @Override
    public long add(Order order) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(order);
    }

    @Override
    public void delete(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(order);
    }

    @Override
    public void update(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }

    @Override
    public int count() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select cust.id from Order cust").list().size();
        //return session.createQuery("select count(*) from Order").executeUpdate();
    }

    @Override
    public int clear() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("delete from Order").executeUpdate();
    }
}

package ru.sbt.carshow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sbt.carshow.model.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer").list();
    }

    @Override
    public Customer getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public long add(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Override
    public int count() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select cust.id from Customer cust").list().size();
    }

    @Override
    public int clear() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("delete from Customer").executeUpdate();
    }
}

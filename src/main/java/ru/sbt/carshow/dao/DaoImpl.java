package ru.sbt.carshow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.carshow.model.Customer;

import java.util.List;

@Component
public class DaoImpl<T> implements Dao<T> {

    private final SessionFactory sessionFactory;

    @Autowired
    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer").list();
    }

    @Override
    public T getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public long add(T customer) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(customer);
    }

    @Override
    public void delete(T customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
    }

    @Override
    public void update(T customer) {
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

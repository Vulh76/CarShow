package ru.sbt.carshow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.carshow.model.Customer;

import java.util.List;

@Component
public class DaoImpl implements Dao {

    private final SessionFactory sessionFactory;

    @Autowired
    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> getAll(Class<T> cls) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from " + cls.getSimpleName()).list();
    }

    @Override
    public <T> T getById(Class<T> cls, long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(cls, id);
    }

    @Override
    public <T> long add(Class<T> cls, T customer) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(customer);
    }

    @Override
    public <T> void delete(Class<T> cls, T customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
    }

    @Override
    public <T> void update(Class<T> cls, T customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Override
    public <T> int count(Class<T> cls) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select cust.id from Customer cust").list().size();
    }

    @Override
    public <T> int clear(Class<T> cls) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("delete from Customer").executeUpdate();
    }
}

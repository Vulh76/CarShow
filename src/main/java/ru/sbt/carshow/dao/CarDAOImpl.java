package ru.sbt.carshow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sbt.carshow.model.Car;

import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public CarDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Car").list();
    }

    @Override
    public Car getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }

    @Override
    public long add(Car car) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(car);
    }

    @Override
    public void delete(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(car);
    }

    @Override
    public void edit(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.update(car);
    }

    @Override
    public int count() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select car.id from Customer car").list().size();
    }

    @Override
    public int clear() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("delete from Car ").executeUpdate();
    }

}

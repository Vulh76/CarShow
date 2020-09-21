package ru.sbt.carshow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntityDAOImpl implements EntityDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EntityDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> getAll(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from " + clazz.getSimpleName()).list();
    }

    @Override
    public <T> T getById(Class<T> clazz, long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(clazz, id);
    }

    @Override
    public <T> long add(T entity) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(entity);
    }

    @Override
    public <T> void delete(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public <T> void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public <T> int count(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select entity.id from " + clazz.getSimpleName() + " entity").list().size();
    }

    @Override
    public <T> int clear(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("delete from " + clazz.getSimpleName()).executeUpdate();
    }
}

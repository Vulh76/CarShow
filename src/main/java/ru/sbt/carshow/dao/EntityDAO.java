package ru.sbt.carshow.dao;

import java.util.List;

public interface EntityDAO {
    <T> List<T> getAll(Class<T> clazz);
    <T> T getById(Class<T> clazz, long id);
    <T> long add(T entity);
    <T> void delete(T entity);
    <T> void update(T entity);
    <T> long count(Class<T> clazz);
    <T> long clear(Class<T> clazz);
}
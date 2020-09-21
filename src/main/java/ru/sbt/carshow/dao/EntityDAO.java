package ru.sbt.carshow.dao;

import java.util.List;

public interface EntityDAO {
    <T> List<T> getAll(Class<T> clazz);
    <T> T getById(Class<T> clazz, long id);
    <T> long add(T entity);
    <T> void delete(T entity);
    <T> void update(T entity);
    <T> int count(Class<T> clazz);
    <T> int clear(Class<T> clazz);
}
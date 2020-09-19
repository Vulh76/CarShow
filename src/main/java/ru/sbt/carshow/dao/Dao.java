package ru.sbt.carshow.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();
    T getById(long id);
    long add(T item);
    void delete(T item);
    void update(T item);
    int count();
    int clear();
}

package ru.sbt.carshow.dao;

import java.util.List;

public interface Dao {
    <T> List<T> getAll(Class<T> cls);
    <T> T getById(Class<T> cls, long id);
    <T> long add(Class<T> cls, T item);
    <T> void delete(Class<T> cls, T item);
    <T> void update(Class<T> cls, T item);
    <T> int count(Class<T> cls);
    <T> int clear(Class<T> cls);
}
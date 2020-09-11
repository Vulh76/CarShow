package ru.sbt.carshow.dao;

import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;

import java.util.List;

public interface CarDAO {
    List<Car> getAll();
    Car getById(long id);
    long add(Car car);
    void delete(Car car);
    void edit(Car car);
    int count();
    int clear();
}

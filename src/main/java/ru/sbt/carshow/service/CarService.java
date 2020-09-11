package ru.sbt.carshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.carshow.dao.CarDAO;
import ru.sbt.carshow.model.Car;

import java.util.List;

@Component
public class CarService {

    private final CarDAO carDAO;

    @Autowired
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getAll() {
        return carDAO.getAll();
    }

    public Car getById(long id) {
        return carDAO.getById(id);
    }

    public long add(Car car) {
        return carDAO.add(car);
    }

    public void delete(Car car) {
        carDAO.delete(car);
    }

    public void edit(Car car) {
        carDAO.edit(car);
    }

    public int count() {
        return carDAO.count();
    }

    public int clear() {
        return carDAO.clear();
    }

}

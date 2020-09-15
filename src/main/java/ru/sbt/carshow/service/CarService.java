package ru.sbt.carshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.carshow.dao.CarDAO;
import ru.sbt.carshow.model.Car;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CarService {

    private final CarDAO carDAO;

    @Autowired
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Transactional
    public List<Car> getAll() {
        return carDAO.getAll();
    }

    @Transactional
    public Car getById(long id) {
        return carDAO.getById(id);
    }

    @Transactional
    public long add(Car car) {
        return carDAO.add(car);
    }

    @Transactional
    public void delete(Car car) {
        carDAO.delete(car);
    }

    @Transactional
    public void update(Car car) {
        carDAO.update(car);
    }

    @Transactional
    public int count() {
        return carDAO.count();
    }

    @Transactional
    public int clear() {
        return carDAO.clear();
    }
}

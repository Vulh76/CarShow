package ru.sbt.carshow.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.data.util.ReflectionUtils;
import ru.sbt.carshow.dao.EntityDAOImpl;
import ru.sbt.carshow.model.Car;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

public class CarShowServiceImplTest {

    private EntityDAOImpl entityDAO;
    private CarShowServiceImpl carShowService;

    @Before
    public void setUp() {
        entityDAO = Mockito.mock(EntityDAOImpl.class);
        carShowService = new CarShowServiceImpl(entityDAO);

        HashMap<Long, Car> longCarHashMap = new HashMap<>();
        AtomicLong atomicLong = new AtomicLong();

        Mockito.when(entityDAO.add(Mockito.any())).thenAnswer(i -> {
            long id = atomicLong.incrementAndGet();
            Car argument = i.getArgument(0, Car.class);
            Field field = argument.getClass().getDeclaredField("id");
            field.setAccessible(true);
            ReflectionUtils.setField(field, argument, id);
            longCarHashMap.put(id, argument);
            return id;
        });

        Mockito.when(entityDAO.getById(Mockito.any(), Mockito.anyLong())).thenAnswer(i ->
                longCarHashMap.get(i.getArgument(1, Long.class))
        );
    }

    @Test
    public void addCarTest1() {
        Car car = new Car();
        carShowService.addCar(car);

        Car car1 = carShowService.getCar(car.getId());
        assertNotNull(car1);
    }

    @Test
    public void addCarTest2() {
        ArgumentCaptor<Car> captor = ArgumentCaptor.forClass(Car.class);
        Mockito.doReturn(1L).when(entityDAO).add(captor.capture());
        //Mockito.when(carDAO.add(captor.capture())).thenReturn(1L);

        Car car = new Car();
        Car car2 = new Car();
        carShowService.addCar(car);
        carShowService.addCar(car2);

        List<Car> allValues = captor.getAllValues();
        assertEquals(2, allValues.size());
        assertEquals(car, allValues.get(0));
        assertEquals(car2, allValues.get(1));
    }
}
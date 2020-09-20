package ru.sbt.carshow.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.data.util.ReflectionUtils;
import ru.sbt.carshow.dao.CarDAOImpl;
import ru.sbt.carshow.dao.CustomerDAOImpl;
import ru.sbt.carshow.dao.OrderDAOImpl;
import ru.sbt.carshow.model.Car;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

public class CarShowServiceTest {

    private OrderDAOImpl orderDAO;
    private CustomerDAOImpl customerDAO;
    private CarDAOImpl carDAO;
    private CarShowService carShowService;

    @Before
    public void setUp() throws Exception {
        orderDAO = Mockito.mock(OrderDAOImpl.class);
        customerDAO = Mockito.mock(CustomerDAOImpl.class);
        carDAO = Mockito.mock(CarDAOImpl.class);
        carShowService = new CarShowService(customerDAO, carDAO, orderDAO);

        HashMap<Long, Car> longCarHashMap = new HashMap<>();
        AtomicLong atomicLong = new AtomicLong();

        Mockito.when(carDAO.add(Mockito.any())).thenAnswer(i -> {
            long id = atomicLong.incrementAndGet();
            Car argument = i.getArgument(0, Car.class);
            Field field = argument.getClass().getDeclaredField("id");
            field.setAccessible(true);
            ReflectionUtils.setField(field, argument, id);
            longCarHashMap.put(id, argument);
            return null;
        });

        Mockito.when(carDAO.getById(Mockito.anyLong())).thenAnswer(i -> longCarHashMap.get(i.getArgument(0, Long.class)));
    }

    @Test
    public void testName() {
        Car car = new Car();
        carShowService.addCar(car);

        Car car1 = carShowService.getCar(car.getId());
        assertNotNull(car1);
    }

    @Test
    public void testName2() {
        ArgumentCaptor<Car> captor = ArgumentCaptor.forClass(Car.class);
        Mockito.doReturn(1L).when(carDAO).add(captor.capture());
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
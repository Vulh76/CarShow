package ru.sbt.carshow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.carshow.config.AppConfig;
import ru.sbt.carshow.dao.OrderDAO;
import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.model.Order;
import ru.sbt.carshow.service.CarService;
import ru.sbt.carshow.service.CustomerService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        CarService carService = applicationContext.getBean(CarService.class);

        customerService.add(new Customer("Андрей", "Иванов", LocalDate.of (1976, 3, 25)));
        customerService.add(new Customer("Илья", "Думаченко",  LocalDate.of (1973, 6, 14)));
        customerService.add(new Customer("Наталья", "Синичкина",  LocalDate.of (1986, 8, 15)));
        customerService.add(new Customer("Владимир", "Орлов",  LocalDate.of (1990, 1, 27)));
        customerService.add(new Customer("Елизавета", "Котова",  LocalDate.of (1991, 7, 2)));
        customerService.add(new Customer("Оксана", "Саратова",  LocalDate.of (1988, 11, 30)));
        customerService.add(new Customer("Александр", "Вертушкин",  LocalDate.of (1978, 3, 16)));
        customerService.add(new Customer("Виктория", "Соколова",  LocalDate.of (1994, 1, 9)));

        carService.add(new Car("Mercedes", "35 AMG 4MATIC", "Black", 3500000));
        carService.add(new Car("Mercedes", "4MATIC OS", "Black", 4550000));
        carService.add(new Car("Ferrari", "488 Pista", "Red", 23000000));
        carService.add(new Car("Ferrari", "F8 Tributo", "Yellow", 28000000));
        carService.add(new Car("Nissan", "Terrano", "Gray", 890000));
        carService.add(new Car("Skoda", "OCTAVIA", "Black", 1140000));
        carService.add(new Car("Skoda", "RAPID", "Blue", 830000));
        carService.add(new Car("Lada", "Granda", "White", 1000));


        OrderDAO orderDAO = applicationContext.getBean(OrderDAO.class);
        Order order = orderDAO.add(2L, 5L);
        order = orderDAO.add(1L, 3L);
        order = orderDAO.add(4L, 3L);


        /*Car car = carService.getById(5L);
        Customer customer = customerService.getById(2L);
        Order order = new Order(LocalDateTime.now(), customer, car);
        customer.addOrder(order);*/
        //customerService.update(customer);

    }
}
